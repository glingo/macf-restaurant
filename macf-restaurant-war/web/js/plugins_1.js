// Avoid `console` errors in browsers that lack a console.
(function() {
    var method;
    var noop = function () {};
    var methods = [
        'assert', 'clear', 'count', 'debug', 'dir', 'dirxml', 'error',
        'exception', 'group', 'groupCollapsed', 'groupEnd', 'info', 'log',
        'markTimeline', 'profile', 'profileEnd', 'table', 'time', 'timeEnd',
        'timeline', 'timelineEnd', 'timeStamp', 'trace', 'warn'
    ];
    var length = methods.length;
    var console = (window.console = window.console || {});

    while (length--) {
        method = methods[length];

        // Only stub undefined methods.
        if (!console[method]) {
            console[method] = noop;
        }
    }
}());

(function ($) {
    'use strict';
    $(document).ready(function () {

        // Tabs
        $('ul.tabs').each(function () {
            var $active, $content, $links = $(this).find('a');

            $active = $($links.filter('[href="' + location.hash + '"]')[0] || $links[0]);
            $active.addClass('active');

            $content = $($active[0].hash);
            $content.addClass('active');

            $links.not($active).each(function () {
                $(this.hash).hide().removeClass('active');
            });

            $(this).on('click', 'a', function () {
                $active.removeClass('active');
                $content.removeClass('active').hide();

                $active = $(this);
                $content = $(this.hash);

                $active.addClass('active');
                $content.addClass('active').show();
                return false;
            });
        });

        // Toggle panels
        $('.toggle-panel').each(function () {
            var h = $(this).height();

            if ($(this).hasClass('active')) {
                $(this).height(h);
            } else {
                $(this).height(h).addClass('no-height');
            }
        });

        $('.toggle-header').on('click', 'a', function () {
            $(this).parent().toggleClass('active');
            var $panel = $(this).parent().next('.toggle-panel');

            if ($panel.hasClass('active')) {
                $panel.removeClass('active');
            }
            $panel.toggleClass('no-height');
            return false;
        });

        // To-top button	
        var btn = $('.totop');
        $(btn).hide();

        $(window).scroll(function () {
            if ($(this).scrollTop() > 100) {
                $(btn).fadeIn();
            } else {
                $(btn).fadeOut();
            }
        });

        $.easing.customEasing = function (p, x) {
            return Math.pow(p, x && x[0] || 4);
        };

        $(btn).on('click', function () {
            $('html, body').animate({
                scrollTop: 0
            }, 500, 'customEasing');
            return false;
        });

    });
})(jQuery);

(function ($) {
    'use strict';
    $(window).on('load', function () {

        // filters
        $('#filters a').on('click', function () {
            
            var $this = $(this);
            if ($this.hasClass('selected')) {
                return false;
            }

            var $optionSet = $this.parents('.option-set');
            $optionSet.find('.selected').removeClass('selected');
            $this.addClass('selected');
            return false;
        });
    });
})(jQuery);
