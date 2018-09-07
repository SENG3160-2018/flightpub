const $ = require('jquery');
window.jQuery = $;
window.Popper = require('popper.js');
require('bootstrap');
window.moment = require('moment');

import dt from 'datatables.net-bs4';

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
    $('.datetimepicker-input').datetimepicker({
        format: 'DD/MM/YY hh:mm a'
    });
})();

$(document).ready(function() {
    $('#results .table.datatable').DataTable();
});