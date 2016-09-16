$(document).ready(init);

function init() {
    tooltipPosition();
    $('.modal').on('shown.bs.modal', function() {        
        $(window).resize(tooltipPosition);
             
        $('.accordProfile').on("shown.bs.collapse hidden.bs.collapse", function() {
            $('span',this).toggleClass("glyphicon-plus glyphicon-minus");
        });
    });
}

function tooltipPosition() {
    if($(document).width() < 768) {
        $('[data-toggle="tooltip"]').tooltip('destroy').tooltip({placement:'right'});
    } else {
        $('[data-toggle="tooltip"]').tooltip('destroy').tooltip({placement:'top'});
    }
}