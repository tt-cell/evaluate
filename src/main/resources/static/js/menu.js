//菜单栏列表
$(function () {
    let evaluates_id = 0;

    //判断登录的人是不是领导
    var list = $("#usersList").text()
    console.log(list)
    console.log($('li a:contains(领导评价)'))
    if (list !== "3") {
        $('body').on('click', 'li a:contains(领导评价)', function () {
            $(this).removeAttr('href')
            alert('对不起，你不是领导！')
        })
    }

    $.ajax({
        url: '/menu',
        type: 'GET',
        dataType: 'json',
        success: function (res) {
            res.data.forEach(function (data) {
                if (data.children) {
                    var SonUlhtml = `<ul id="exampledropdownDropdown" class="collapse list-unstyled "></ul>`
                    var LihtmlOne = `<li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>${data.title}</a>`
                    var $SonUlhtml = $(SonUlhtml)
                    var $LihtmlOne = $(LihtmlOne)
                    console.log(data.children)
                    data.children.forEach(function (children) {
                        var SonTitleHtml = `<li><a href="${children.href}">${children.title}</a></li>`
                        var $SonTitleHtml = $(SonTitleHtml)
                        $SonTitleHtml.appendTo($SonUlhtml)
                    })
                    $SonUlhtml.appendTo($LihtmlOne)
                    $LihtmlOne.appendTo("#MenuList");
                    // $("#exampledropdownDropdown").click(function () {
                    //     this.children().slideToggle(1000)
                    //     this.next().children.slideUp(1000)
                    // })
                } else {
                    var LihtmlTwo = `<li><a href="${data.href}"><i class="fa fa-bar-chart"></i>${data.title}</a></li>`
                    var $LihtmlTwo = $(LihtmlTwo)
                    $LihtmlTwo.appendTo("#MenuList");
                }
            })
        },
        error: function (err) {
            document.write(err.message)
        }
    })
    // $(":contains(学生评教)").click(function () {
    //     evaluates_id=1
    //     console.log('hfvkjhfuv')
    //     $.ajax({
    //         //url:`studentTargets`,
    //         url : 'studentTargets/'+evaluates_id,//（1）请求的action路径,可以传递参数到后台
    //         type:'post',
    //         //data:{evaluates_id:type},
    //         success:function (res) {
    //            alert(res)
    //         },
    //         error:function (err) {
    //             alert(err.message)
    //         }
    //     })
    // })
    $('body').on('click', 'li a:contains(学生评教)', function () {
        evaluates_id=1
        console.log(evaluates_id)
        var a = $.ajax({url:`/studentEvaluates?evaluates_id=${evaluates_id}`, async:false})
        console.log(a.responseText)
    })
    $('body').on('click', 'li a:contains(同行评教)', function () {
        evaluates_id=2
    })
    $('body').on('click', 'li a:contains(领导评教)', function () {
        evaluates_id=3
    })
    $('body').on('click', 'li a:contains(自我评教)', function () {
        evaluates_id=4
    })


})