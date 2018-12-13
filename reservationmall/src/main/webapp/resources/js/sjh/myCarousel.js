// Owl carousel
$('.owl-search-sjh.owl-carousel').each(function () {
        $(this).owlCarousel({
            items: 3,
            loop: true,
            margin: 10,
            lazyLoad: false,
         //   mouseDrag: false,
         //   touchDrag:false,
            nav: true,
            navText: [
                "<i class='fa fa-angle-left'></i>",
                "<i class='fa fa-angle-right'></i>"
            ],
            dots: false,
            autoplay: false,
            autoplayTimeout: 5000,
            autoplayHoverPause: true
        });
    });

$('.owl-search-sjh2.owl-carousel').each(function () {
    $(this).owlCarousel({
        items: 1,
        loop: true,
        margin: 10,
        lazyLoad: true,
        nav: true,
        navText: [
            "<i class='fa fa-angle-left'></i>",
            "<i class='fa fa-angle-right'></i>"
        ],
        dots: false,
        autoplay: true,
        autoplayTimeout: 5000,
        autoplayHoverPause: true
    });
});