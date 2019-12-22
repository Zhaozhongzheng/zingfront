//保存旅行计划
function savePlan(){
    $("#saveBtn").attr("disabled", true);
    $.ajax({
        type : "POST",
        contentType: "application/x-www-form-urlencoded",
        url : "/savePlan.do",
        data : $("#myPlanForm").serialize()+"&userid=1",
        success : function(data) {
            if (data.status == 0){
                alert("添加成功");
                window.location.reload();
            }else{
                alert(data.msg);
            }
            $("#saveBtn").attr("disabled", false);
        },
    });
}
$(document).ready(function() {
    getHasGo();
    getPlanGo();
    //初始化地图
    var map = new BMap.Map("container");
    //创建地址解析器
    var geoc = new BMap.Geocoder();
    //根据中心点创建地图
    map.centerAndZoom("甘肃", 5);
    //添加控件，平移缩放控件
    map.addControl(new BMap.NavigationControl({type: BMAP_NAVIGATION_CONTROL_SMALL}));
    map.enableScrollWheelZoom(); // 启动鼠标滚轮操作

    //获取所有去过的省份
    function getHasGo(){
        $.ajax({
            type : "POST",
            contentType: "application/x-www-form-urlencoded",
            url : "/getHasGoPosition.do",
            data : "userid=1",
            success : function(data) {
                if (data.status == 0){
                    $.each(data.data,function (index,value) {
                        var marker = new BMap.Marker(new BMap.Point(value.posX,value.posY));  // 创建标注
                        var content = "<p>地点："+value.province+"</p>" +
                            "<p>时间："+value.date+"</p>" +
                            "<p>备注："+value.memo+"</p>";
                        map.addOverlay(marker);// 将标注添加到地图中
                        getBoundary(value.province);
                        var opts = {
                            width : 250,     // 信息窗口宽度
                            height: 200,     // 信息窗口高度
                            title : "【我去过】",//信息窗口标题
                            enableMessage:true//设置允许信息窗发送短息
                        };
                        addMouseHandler(content,marker,opts);
                    })
                }else{
                    alert(data.msg);
                }
            },
        });
    }

    //获取制定旅行计划的省份
    function getPlanGo(){
        $.ajax({
            type : "POST",
            contentType: "application/x-www-form-urlencoded",
            url : "/getPlanGoPosition.do",
            data : "userid=1",
            success : function(data) {
                if (data.status == 0){
                    $.each(data.data,function (index,value) {
                        var marker = new BMap.Marker(new BMap.Point(value.posX,value.posY));  // 创建标注
                        var content = "<p>地点："+value.province+"</p>" +
                            "<p>旅行计划："+value.content+"</p>";
                        map.addOverlay(marker);// 将标注添加到地图中
                        var opts = {
                            width : 250,     // 信息窗口宽度
                            height: 200,     // 信息窗口高度
                            title : "【旅行计划】",//信息窗口标题
                            enableMessage:true//设置允许信息窗发送短息
                        };
                        addMouseHandler(content,marker,opts);
                    })
                }else{
                    alert(data.msg);
                }
            },
        });
    }

    //添加标注鼠标事件
    function addMouseHandler(content,marker,opts){
        marker.addEventListener("mouseover",function(e){
            openInfo(content,e,opts)}
        );
    }

    //开启信息窗口
    function openInfo(content,e,opts){
        var p = e.target;
        var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
        var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    }

    //画出省份轮廓图
    function getBoundary(name){
        var bdary = new BMap.Boundary();
        bdary.get(name, function(rs){       //获取行政区域
            var count = rs.boundaries.length; //行政区域的点有多少个
            for(var i = 0; i < count; i++){
                var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
                map.addOverlay(ply);  //添加覆盖物
            }
        });
    }

    //地图点击事件
    map.addEventListener("click", function(e){
        //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
        var pt = e.point;
        geoc.getLocation(pt, function(rs){
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;

            var opts = {
                width : 200,     // 信息窗口宽度
                height: 300,     // 信息窗口高度
                title : addComp.province, // 信息窗口标题
                enableMessage:true,//设置允许信息窗发送短息
                message:"信息窗口"
            }

            var html = "<form id='myPlanForm' name='myPlanForm' method='post'> 我的旅行计划：" +
                "<input type='text' name='province' hidden value='"+addComp.province+"'/>" +
                "<input type='text' name='posX' hidden value='"+pt.lng+"'/>" +
                "<input type='text' name='posY' hidden value='"+pt.lat+"'/>" +
                "<textarea name='content' style='height: 200px'></textarea> " +
                "<br></form> <button id='saveBtn' onclick='savePlan()'>做计划</button> ";

            var infoWindow = new BMap.InfoWindow(html, opts);  // 创建信息窗口对象
            map.openInfoWindow(infoWindow,pt); //开启信息窗口
        });
    });
});
