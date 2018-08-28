const $ = require('jquery');
window.jQuery = $;
window.Popper = require('popper.js');
require('bootstrap');
window.moment = require('moment');

require('../../lib/bootstrap-4-master/build/js/tempusdominus-bootstrap-4.min');

(() => {
    let $review = $('#review-bubble');
    setTimeout(() => {
        $review.slideDown(500);
    }, 5000);
    $review.find('.close').click(() => {
        $review.slideUp(500);
    });
})();

(() => {
    $('.datetimepicker-input').datetimepicker();
})();
