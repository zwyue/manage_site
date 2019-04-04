
    //首页 热门活动
    $(function () {
        DatatoLoad();
    });

    function DatatoLoad() {
        //分页
        var pageNum = 0;    //初始化页数为第一页
        var pageSize = 5;   //列表数量为7条
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            var totalSize = 0; //初始化数据总数
            getDatasSize();

            function getDatasSize() {
                $.ajax({
                    type: 'get',
                    async: false,
                    url: "/admin/activity/list",
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize
                    },
                    dataType: "json",
                    success: function (data) {
                        totalSize = data.data.total; //获得数据总条数
                        var html = '';
                        pageCurrent = data.data.pageNum;//获取当前页
                        pageNow = (pageCurrent - 1) * 10; //当前页数的序号

                        $.each(data.data.list, function (i, result) {
                            html += "<tr>";
                            html += "<td>" + (pageNow + i + 1) + "</td>" + "<td>" + result.activityName + "</td>" + "<td>" + result.start_time + "</td>" +"<td>" + result.end_time + "</td>" +
                                "<td>" + result.sponsor + "</td>" + "<td>" + result.activityName + "</td>" +
                                "<td><a href='JavaScript:;' onclick='delect(" + result.id + ")' class='layui-icon layui-icon-edit'>删除</a>" +
                                "<a href='/admin/jump/activity/update?id=" + result.id + "' class='layui-icon layui-icon-delete'>修改</a>"
                            // "<a href='dagl_hjqkck.html?id=" + result.id + "' class='bg change'>查看</a>" +
                            // "<a href='api/award/export?id=" + result.id + "' class='bg look'>导出</a></td>";
                            html += "</tr>";
                        })
                        $("#activityList").html(html);
                    },
                    error: function () {
                        layui.use('layer', function () {
                            var layer = layui.layer;
                            layer.msg('请求列表失败！');
                        });
                    },
                })
            }

            //执行一个laypage
            laypage.render({
                elem: 'demo5',    //分页容器，此处是id
                count: totalSize, //数据总数，从服务端得到
                curr: pageNum,
                limit: pageSize,
                jump: function (obj, first) {
                    pageNum = obj.curr;     //得到当前页，以便向服务端请求对应页的数据。
                    pageSize = obj.limit;   //得到每页显示的条数

                    //首次不执行
                    if (!first) {
                        $("#activityList").empty();
                        getDatasSize();
                    }
                }
            })
        })
    }


    function delect(id) {
        $.ajax({
            type: 'get',
            async: false,
            url: "/admin/activity/deleted/activity",
            data: {
                id:id,
            },
            dataType: "json",
            success: function (data) {
                layer.msg(data.data);
                DatatoLoad();
            },
            error: function () {
                alert('2');

            },
        })
    }

    //查询
    function chaxun() {

        var textName = $('#title').val();

        //分页
        var pageNum = 1;//初始化页数为第一页
        var pageSize = 5;
        layui.use('laypage', function () {
            var laypage = layui.laypage;
            var totalRecord = 0;//初始化总记录数
            getQuery();

            function getQuery() {
                $.ajax({
                    type: 'get',
                    async: false,
                    url: "/admin/activity/list",
                    data: {
                        pageNum: pageNum,
                        pageSize: pageSize,
                        activityName:textName
                    },
                    dataType: "json",
                    success: function (data) {
                        totalSize = data.data.total; //获得数据总条数
                        var html = '';
                        pageCurrent = data.data.pageNum;//获取当前页
                        pageNow = (pageCurrent - 1) * 10; //当前页数的序号

                        $.each(data.data.list, function (i, result) {
                            html += "<tr>";
                            html += "<td>" + (pageNow + i + 1) + "</td>" + "<td>" + result.activityName + "</td>" + "<td>" + result.start_time + "</td>" +"<td>" + result.end_time + "</td>" +
                                "<td>" + result.sponsor + "</td>" + "<td>" + result.activityName + "</td>" +
                                "<td><a href='JavaScript:;' onclick='delect(" + result.id + ")' class='layui-icon layui-icon-edit'>删除</a>" +
                                "<a href='/admin/jump/activity/update?id=" + result.id + "' class='layui-icon layui-icon-delete'>修改</a>"
                            // "<a href='dagl_hjqkck.html?id=" + result.id + "' class='bg change'>查看</a>" +
                            // "<a href='api/award/export?id=" + result.id + "' class='bg look'>导出</a></td>";
                            html += "</tr>";
                        });
                        $("#activityList").html(html);

                    },
                    error: function () {
                        layui.use('layer', function () {
                            var layer = layui.layer;
                            layer.msg('查询失败！');
                        });
                    }
                })
            };

            //执行一个laypage实例
            laypage.render({
                elem: 'demo5',    //分页容器，此处是id
                count: totalSize, //数据总数，从服务端得到
                curr: pageNum,
                limit: pageSize,
                jump: function (obj, first) {
                    pageNum = obj.curr;     //得到当前页，以便向服务端请求对应页的数据。
                    pageSize = obj.limit;   //得到每页显示的条数

                    //首次不执行
                    if (!first) {
                        $("#activityList").empty();
                        getQuery();
                    }
                }
            })
        })
    }


