const $ = require('jquery');
window.jQuery = $;
window.Popper = require('popper.js');
require('bootstrap');
window.moment = require('moment');

import dt from 'datatables.net-bs4';

require('../../lib/bootstrap-4-master/build/js/tempusdominus-bootstrap-4.min');

import payform from 'payform';

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

    let $checkout = $('#checkout');
    if ($checkout) {
        let cardNumber = document.getElementById('card_number');
        payform.cardNumberInput(cardNumber);

        let expiry = document.getElementById('expiry');
        payform.expiryInput(expiry);

        let ccv = document.getElementById('ccv');
        payform.cvcInput(ccv);

        let form = document.getElementById('checkout-form');

        form.addEventListener('submit', function(event) {
            let exp = payform.parseCardExpiry(expiry.value);

            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            } else if (!payform.validateCardNumber(cardNumber.value)) {
                event.preventDefault();
                event.stopPropagation();
                cardNumber.classList.add('is-invalid');
            } else if (!payform.validateCardExpiry(exp.month, exp.year)) {
                event.preventDefault();
                event.stopPropagation();
                expiry.classList.add('is-invalid');
            } else if (!payform.validateCardCVC(ccv.value)) {
                event.preventDefault();
                event.stopPropagation();
                ccv.classList.add('is-invalid');
            }
            form.classList.add('was-validated');
        }, false);
    }
})();

$(document).ready(function() {
    $('#results .table.datatable').DataTable();
});