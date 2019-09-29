//菜单栏列表
$(function () {
    $.ajax({
        url:'/menu',
        type:'GET',
        dataType:'json',
        success:function (res) {
            console.log(res)
            res.data.forEach(function (data) {
                if(data.children){
                    var SonUlhtml = `<ul id="exampledropdownDropdown" class="collapse list-unstyled "></ul>`
                    var LihtmlOne = `<li><a href="#exampledropdownDropdown" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>${data.title}</a>`
                    var $SonUlhtml = $(SonUlhtml)
                    var $LihtmlOne=$(LihtmlOne)
                    console.log(data.children)
                    data.children.forEach(function (children) {
                        console.log(children.href)
                        var SonTitleHtml = `<li><a href="${children.href}">${children.title}</a></li>`
                        var $SonTitleHtml=$(SonTitleHtml)
                        $SonTitleHtml.appendTo($SonUlhtml)
                    })
                    $SonUlhtml.appendTo($LihtmlOne)
                    $LihtmlOne.appendTo("#MenuList");
                    // $("#exampledropdownDropdown").click(function () {
                    //     this.children().slideToggle(1000)
                    //     this.next().children.slideUp(1000)
                    // })
                }else{
                    var LihtmlTwo = `<li><a href="${data.href}"><i class="fa fa-bar-chart"></i>${data.title}</a></li>`
                    var $LihtmlTwo=$(LihtmlTwo)
                    $LihtmlTwo.appendTo("#MenuList");
                }
            })
        },
        error:function (err) {
            document.write(err.message)
        }
    })

})