function sendServer(button) {
    let review;
    if ($(button).hasClass('review-like')) {
        review = 'like';
    } else if ($(button).hasClass('review-hate')) {
        review = 'hate';
    } else {
        return false;
    }
    const reviewId = $(button).closest('.media-right').find('input[name="reviewId"]').val();
    const userId = $('#userId').val();
    const param = {
        type: review,
        reviewId: reviewId,
        userId: userId
    };
    $.ajax({
        url: "/reservationmall/hotel/review.mall",
        data: param,
        dataType: "text", //응답결과로 반환되는 데이터타입(text, html, xml, html, json)
        success: function (data) {
            $(button).children().toggleClass('far');
            $(button).children().toggleClass('fas');
            if ($(button).hasClass('review-like')) {
                $(button).closest('.media').find('.label-large').children().eq(0).text(data);
            }
        },
        error: function (xhr, statusText) {
            alert("(" + xhr.status + ", " + statusText + ")");
        }
    });


}

$(function () {
    $('.review-like').on('click', function () {
        sendServer(this);
        return false;
    });
    $('.review-hate').on('click', function () {
        sendServer(this);
        return false;
    });
});