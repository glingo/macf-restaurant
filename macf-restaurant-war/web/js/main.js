$(function () {

    $(".dropdown-menu > li > a.trigger").on("click", function (e) {
        if ($('#navbar').hasClass('in')) {
            $(this).next().toggle();
            e.preventDefault();
            e.stopPropagation();
        }
    });

});
