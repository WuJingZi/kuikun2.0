$(document).ready(function(){
    setTimeout(function(){
        $(".landing-into-item").eq(0).fadeIn(4000);

        setTimeout(function(){
            $(".landing-into-item").eq(0).fadeOut(1000);

            setTimeout(function(){
                $(".landing-into-item").eq(1).fadeIn(3000);
            }, 500);
        }, 4000);

    }, 1000)

    var lastScrollTop = 0,
        st,
        direction;
    var lastdir = 'up';

    function detectDirection(st) {

        st = window.pageYOffset;

        if (st > lastScrollTop) {
            direction = "down";
        } else {
            direction = "up";
        }

        lastScrollTop = st;
        return  direction;

    }



    if($(".fix-menu").length){
        var win_w	= $(window).width();
        header_elm	= $("#header");
        /*if(win_w>680){
            header_elm	= $("#header");
        }else{
            header_elm	= $(".header-mobile-wrap");
        }*/

        if(win_w>680){
            $(window).scroll(function(){
                /*
                console.log("Asd");
                s_top	= $(window).scrollTop();

                var dir = detectDirection();

                if(dir=="up"){

                    if(s_top > header_elm.height()){

                        //console.log(s_top - parseInt($(".fix-menu").css("top")));

                        if(s_top - parseInt($(".fix-menu").css("top"))< header_elm.height()+2){
                            $(".fix-menu").css('top', s_top-header_elm.height() - 2 + "px");
                            $(".fix-menu").addClass("active");
                        }
                    }else{
                        $(".fix-menu").css("top", "0");
                        $(".fix-menu").removeClass("active");
                    }
                }else{
                    if(s_top - parseInt($(".fix-menu").css("top"))- $(".fix-menu").innerHeight()> header_elm.height()+2){

                        $(".fix-menu").css('top', s_top - header_elm.height()- 2 - $(".fix-menu").innerHeight() + "px");
                    }
                }

                lastdir = dir;
                */
                s_top	= $(window).scrollTop();
                var dir = detectDirection();

                if(dir=="up"){
                    if(s_top > header_elm.height()+130){
                        $(".fix-menu").addClass("active");
                    }else{
                        $(".fix-menu").removeClass("active");
                    }
                }else{
                    $(".fix-menu").removeClass("active");
                }
            });
        }
    }


    $(".scroll_to").click(function(){
        this_target	= $(this).attr("target_elm");
        win_w	= $(window).width();
        if(this_target.length){
            if(win_w>768){
                content_top	= $(this_target).offset().top;
            }else{
                content_top	= $(this_target).offset().top -70;
            }
            $('body, html').stop().animate({
                scrollTop: content_top
            }, 1000, 'easeOutQuint');
        }
    });

    if($(".page-banner-arr").length){
        $(".page-banner-arr").animate({'bottom': "40px", "opacity": "1"}, 1500);
    }


    $(".back2top").click(function(){
        $('body, html').stop().animate({
            scrollTop: 0
        }, 1000, 'easeOutQuint');

    });

    var mobile_menu_btn	= $(".mobile-menu-btn");
    $(".mobile-menu-bar").click(function(){
        $("#header").fadeIn(300);

    })

    $(".header-close-btn").click(function(){
        $("#header").fadeOut(300);

    })


    $(".header-search .search-keyword-wrap a").click(function(){
        if($(".search-keyword-wrap").hasClass("active")){

            $(".search-keyword-wrap").removeClass("active");
        }else{
            $(".search-keyword-wrap").addClass("active");
        }
    });


    $('.search_input_wrap').find('.close').click(function(){
        $('.search_input_wrap').fadeOut('fast');
        $('.search_input_wrap').find('.text').removeClass('active');
    });

    $('.search_input_wrap').find('.bg').click(function(){
        $('.search_input_wrap').fadeOut('fast');
        $('.search_input_wrap').find('.text').removeClass('active');
    });

    $(".mobile-back2top").click(function(){
        $('body, html').stop().animate({
            scrollTop: 0
        }, 1000, 'easeOutQuint');

    })

    function onScroll_back2top(){
        win_top	= $(window).scrollTop();

        if(win_top>400){
            if(!$(".mobile-back2top").hasClass("active")){
                $(".mobile-back2top").addClass("active");
            }
        }else{
            if($(".mobile-back2top").hasClass("active")){
                $(".mobile-back2top.active").removeClass("active");
            }
        }
    }

    $("#ss_wechat").click(function(){
        $(".wechat_popup_wrap").fadeIn(600);
        $(".wechat_bg").fadeIn(600);
    })

    $(".wechat_bg, .close_btn").click(function(){
        $(".wechat_bg").fadeOut(400);
        $(".wechat_popup_wrap").fadeOut(400);
    })
    //nav选中
    $(".header-wrap .header-menu a").each(function(){
        $this = $(this);
        if($this[0].href==String(window.location)){
            $(".header-wrap .header-menu a").removeClass("active");
            $this.addClass("active");
        }
    });
});

function isScrolledIntoView(elem){
    var $elem = $(elem);
    var $window = $(window);

    var docViewTop = $window.scrollTop();
    var docViewBottom = docViewTop + $window.height();

    var distance	= false;

    if($elem.length){

        var elemTop = $elem.offset().top;
        var elemBottom = elemTop + $elem.innerHeight();

        var elemHeight = $elem.innerHeight();
        var winHeight = $window.height();


        view_target_top	= docViewTop + (winHeight*0);

        if(winHeight>elemHeight){

            if((elemBottom-(elemHeight*0.5) <= docViewBottom) && (elemTop+(elemHeight*0.5) >= docViewTop)){

                distance = view_target_top - elemTop;
            }

        }else{

            if(elemTop<docViewTop && elemBottom>docViewBottom){
                distance	= 1;
            }else if(elemTop>docViewTop){
                distance = view_target_top - elemTop;
            }else if(elemBottom>docViewTop){
                distance = view_target_top - docViewBottom;
            }
        }

        if(distance<0){

            distance	= distance*-1;
        }
    }
    return distance;
}