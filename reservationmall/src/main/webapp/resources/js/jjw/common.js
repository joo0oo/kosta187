function calculateDayJjw() {
    const startDay = new Date($('#datetimepicker1 input').val());
    const endDay = new Date($('#datetimepicker2 input').val());
    if (endDay <= startDay) {
        startDay.setDate(startDay.getDate() + 1);
        $('#datetimepicker2').data("DateTimePicker").date(startDay);
    } else {
        const betweenDay = (endDay - startDay) / (1000 * 60 * 60 * 24);
        $('#betweenDay').html(`<strong>${betweenDay}박 ${betweenDay + 1}일</strong>`);
        $('#betweenDay2').html(`<strong>${betweenDay}박 ${betweenDay + 1}일</strong>`);
    }
}

function setDatetimepickerSetting() {
    $('#datetimepicker1').datetimepicker({
        locale: 'ko',
        format: 'YYYY-MM-DD',
        icons: {
            next: "fa fa-chevron-right",
            previous: "fa fa-chevron-left",
        },
        defaultDate: 'now'
    });

    $('#datetimepicker2').datetimepicker({
        useCurrent: false, //Important! See issue #1075
        locale: 'ko',
        format: 'YYYY-MM-DD',
        icons: {
            next: "fa fa-chevron-right",
            previous: "fa fa-chevron-left",
        },
        defaultDate: 'tomorrow'
    });
    $("#datetimepicker1").on("dp.change", function (e) {
        $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        calculateDayJjw();
    });
    $("#datetimepicker2").on("dp.change", function (e) {
        $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        calculateDayJjw();
    });
}

function addsearchPersonNumber(className) {
    const peopleHtml = `<div class="col-md-6">
    <div class="form-group">
      <label>어른 수</label>
      <select class="form-control ${className}" name="searchAdultNumber">
        <option>1</option>
        <option selected>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
      </select>
    </div>
  </div>
  <div class="col-md-6">
    <div class="form-group">
      <label>아이 수</label>
      <select class="form-control ${className}" name="searchChildNumber">
        <option>0</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
      </select>
    </div>
  </div>`;
    return peopleHtml;
}

function changeRoomNumberJjw(element) {
    const beforeValue = parseInt($('#roomNumberHidden').val());
    const thisValue = parseInt(element.value);
    if (beforeValue < thisValue) {
        for (let i = beforeValue + 1; i <= thisValue; i += 1) {
            $('#roomNumberAnchor').append(addsearchPersonNumber('input-lg'));
        }
    } else if (beforeValue > thisValue) {
        for (let i = beforeValue; i > thisValue; i -= 1) {
            for (let j = 0; j < 2; j += 1) {
                $('#roomNumberAnchor').children().last().remove();
            }
        }
    }
}

function changeRoomNumber2Jjw(element) {
    const beforeValue = parseInt($('#roomNumberHidden').val());
    const thisValue = parseInt(element.value);
    if (beforeValue < thisValue) {
        for (let i = beforeValue + 1; i <= thisValue; i += 1) {
            $('#roomNumberAnchor').append(addsearchPersonNumber(''));
        }
    } else if (beforeValue > thisValue) {
        for (let i = beforeValue; i > thisValue; i -= 1) {
            for (let j = 0; j < 2; j += 1) {
                $('#roomNumberAnchor').children().last().remove();
            }
        }
    }
}

// 장소 검색 객체를 생성합니다
var ps = new daum.maps.services.Places();
// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {
    const searchValueInput = $('#searchValueInput');
    var keyword = searchValueInput.val();

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        searchValueInput.focus();
        $('#searchForm').prev().remove();
        $('#searchForm').before(`<div class="col-md-12 alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>검색 내용을 입력해주세요.</div>`);
        return false;
    } else {
        // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
        ps.keywordSearch(keyword, placesSearchCB);
    }
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === daum.maps.services.Status.OK) {
        const address = data[0].address_name.split(' ');
        if (address[0] === '서울') {
            $('#searchValueInputHidden').val(address[1]);
        } else {
            // 서울이 아닐때
            alert('서울이 아닌데?');
            return;
        }

    } else if (status === daum.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === daum.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

function owlSearch() {
    $('[class*=owl-search-].owl-carousel').each(function () {
        $(this).owlCarousel({
            items: 1,
            loop: true,
            margin: 10,
            autoHeight: true,
            lazyLoad: true,
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
}

function initButtons(button) {
    const buttons = $(button).closest('tbody').find('.roomSelect');
    buttons.removeClass('active');
    buttons.addClass('btn-primary');
}

function addRoomInfo(button) {
    if (!$('#userId').val()) {
        const reserveB = $(button).closest('.modal-body').next().find('.reservationButton');
        reserveB.prev().remove();
        reserveB.before(`<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><a class="alert-link room-login-alert" data-toggle="modal" data-target="#loginModal"><strong>로그인</strong></a>을 하셔야 선택할 수 있습니다.</div>`);
        $(button).closest('.modal').animate({ scrollTop: reserveB.offset().top * 3 }, 400);
        return;
    }

    $(button).addClass('active');
    $(button).removeClass('btn-primary');
    const hotelId = $(button).next().val(); // hotel Id
    const roomNum = $(button).next().next().val(); // room num
    const roomId = $(button).next().next().next().val(); //room Id
    const roomPrice = $(button).next().next().next().next().val(); // room Name
    const roomName = $(button).next().next().next().next().next().val(); // room Name
    const adultNumber = $(`#adultNumber${roomNum}`).val();
    const childNumber = $(`#childNumber${roomNum}`).val();
    $(`#roomSelected${hotelId}-${roomNum}`).val(`${hotelId}-${roomNum}-${roomId}-${adultNumber}-${childNumber}-${roomPrice}-${roomName}`);
}

function addHotmlRoomInfo(button) {
    if (!$('#userId').val()) {
        const reserveB = $(button).closest('.modal-body').next().find('.reservationButton');
        reserveB.prev().remove();
        reserveB.before(`<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><a class="alert-link room-login-alert" data-toggle="modal" data-target="#loginModal"><strong>로그인</strong></a>을 하셔야 선택할 수 있습니다.</div>`);
        $(button).closest('.modal').animate({ scrollTop: reserveB.offset().top * 3 }, 500);
        return;
    }

    const roomInfos = $(button).next().children();
    let isGood = true;
    roomInfos.each(function (i) {
        if (!$(this).val()) {
            $(button).prev().remove();
            $(button).before(`<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>예약할 방을 모두 선택해 주세요.</div>`);
            isGood = false;
            return;
        }
    });
    if (isGood) {
        $('#headinghotel').next().remove();
        $('#headingRoom').next().remove();
        let roomNames = '';
        let hotelId;
        let totalPrice = 0;
        let html =
            `<div id="collapseRoom" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingRoom">
            <div class="panel-body">
                <div class="panel-group" id="roomSelectInfos" role="tablist" aria-multiselectable="true">`;
        roomInfos.each(function (i) {
            const value = $(this).val().split('-');
            hotelId = value[0];
            const roomNum = value[1];
            const roomId = value[2];
            const adultNumber = value[3];
            const childNumber = value[4];
            const roomPrice = value[5];
            const roomName = value.length > 7 ? value.slice(6).join('-') : value[6];
            html += `<div class="panel panel-success">
        <div class="panel-heading" role="tab" id="room-${i}">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#roomSelectInfos" href="#room-hotelId-${i}" data-target="#room-hotelId-${i}"
                aria-expanded="false" aria-controls="room-hotelId-${i}">${roomName} (어른 : ${adultNumber}명, 아이 ${childNumber}명), ${roomPrice}원</a>
            </h4>
        </div>
        <div id="room-hotelId-${i}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="room-${i}">
            <div class="panel-body">`;
            html += $(`#select${hotelId}-${roomNum}-${roomId}`).html();
            html += `</div></div></div>`;

            totalPrice += parseInt(roomPrice);
            roomNames += `, ${roomName}`;
        });

        let htmlHotel = '<div id="collapseHotel" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingHotel"><div class="panel-body">';
        htmlHotel += $('#hotelHtml').html();
        htmlHotel += '</div></div>';

        const hotelName = $(`#Modal-label-${hotelId}`).html();

        $('#collapseHotelAnchor').html(`선택 호텔 정보 (${hotelName})`);
        $('#collapseRoomAnchor').html(`선택 방 정보 (${roomNames.slice(2)})`);
        $('#headinghotel').after(htmlHotel);
        $('#headingRoom').after(html);
        $('#totalPrice').html(`총 결제 금액 : ${totalPrice}원`);

        $('#hotelId').val(hotelId);
        $('#roomName').val(roomNames.slice(2));
        $('#totalPrice2').val(totalPrice);

        $(`#Modal-${hotelId}`).modal('hide');

        window.dispatchEvent(new Event('resize'));
    }
}

function searchHotelEvent() {
    const searchValueInput = $('#searchValueInput');
    const searchHotelRate = $('input[name="searchHotelRate"]');
    const searchMinPrice = $('input[name="searchMinMoney"]');
    const searchMaxPrice = $('input[name="searchMaxMoney"]');
    if (!searchValueInput.val().replace(/^\s+|\s+$/g, '')) {
        searchValueInput.focus();
        $('#searchForm').prev().remove();
        $('#searchForm').before(`<div class="col-md-12 alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>검색 내용</strong>을 입력해주세요.</div>`)
    } else if (!searchHotelRate.val() && !checkValidFloat(searchHotelRate)) {
        return;
    } else if (!searchHotelRate.val() && !checkValidFloat(searchMinPrice)) {
        return;
    } else if (!searchHotelRate.val() && !checkValidFloat(searchMaxPrice)) {
        return;
    } else {
        if ($('#searchValueType').val() === 'searchLocation') {
            searchPlaces();
            setTimeout(() => {
                $('#searchForm').submit();
            }, 500);
        } else {
            $('#searchValueInputHidden').val(searchValueInput.val());
            $('#searchForm').submit();
        }
    }
}

function checkValidNumber(input) {
    if ($(input).val() && !isValidIntJjw($(input).val(), 1, 20)) {
        $(input).focus();
        if (!$(input).closest('.extraSearch').children().last().hasClass('alert')) {
            $(input).closest('.extraSearch').append(`<div class="col-md-12 alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>비용은 0보다 큰 숫자 값을 입력해주세요. (최대 20자리)</div>`)
        }
        return false;
    }
    if ($(input).closest('.extraSearch').children().last().hasClass('alert')) {
        $(input).closest('.extraSearch').children().last().remove();
    }
    return true;
}

function checkValidFloat(input) {
    if ($(input).val() && !isValidFloatJjw($(input).val(), 2)) {
        $(input).focus();
        if (!$(input).closest('.extraSearch').next().hasClass('alert')) {
            $(input).closest('.extraSearch').after(`<div class="col-md-12 alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>평점은 1 ~ 5 사이의 소수 점 아래 2째 자리 까지 입력 가능합니다.</div>`)
        }
        return false;
    }
    if ($(input).closest('.extraSearch').next().hasClass('alert')) {
        $(input).closest('.extraSearch').next().remove();
    }
    return true;
}

function eventRegist() {
    $('#roomNumber').on('mousedown', function () {
        $('#roomNumberHidden').val(parseInt(this.value));
    });

    $('#roomNumber').on('change', function () {
        changeRoomNumberJjw(this);
    });

    $('#roomNumber2').on('mousedown', function () {
        $('#roomNumberHidden').val(parseInt(this.value));
    });

    $('#roomNumber2').on('change', function () {
        changeRoomNumber2Jjw(this);
    });

    $('#searchValueInput').on('change', function () {
        if ($('#searchValueType').val() === 'searchLocation') {
            searchPlaces();
        } else {
            $('#searchValueInputHidden').val($('#searchValueInput').val());
        }
    });

    $('#searchHotelButton').on('click', function () {
        searchHotelEvent();
    });

    $('#searchExtra').on('click', function () {
        $('.extraSearch').find('input:text').each(function () {
            $(this).val('');
        });
    });

    $('.modal').on('show.bs.modal', function () {
        // window.dispatchEvent(new Event('resize'));
    });
    
    $('.modal').on('shown.bs.modal', function () {
        window.dispatchEvent(new Event('resize'));
        $(this).find('.owl-carousel').trigger('prev.owl.carousel');
        setTimeout(() => {
            $(this).find('.owl-carousel').trigger('prev.owl.carousel');
        }, 300);
        setTimeout(() => {
            $(this).find('.owl-carousel').trigger('prev.owl.carousel');
        }, 600);
    });

    $('[id^="locationMap-"').on('click', function () {
        setTimeout(() => {
            window.dispatchEvent(new Event('resize'));
        }, 300);
    });

    $('.roomSelect').on('click', function () {
        initButtons(this);
        addRoomInfo(this);
    });

    $('.reservationButton').on('click', function () {
        addHotmlRoomInfo(this);
    });

    $(document).on('click', '.room-login-alert', function () {
        $(this).closest('.modal').modal('hide');
    });

    $('#loginBtn').on('click', function () {
        if (window.location.pathname === '/reservationmall/hotel/searchhotel.mall') {
            $('#loginIdHidden').val($('#login_id').val());
            $('#loginPwHidden').val($('#login_pw').val());
            $('#searchForm').attr('action', '/reservationmall/login/controller.mall');
            $('#searchForm').submit();
            return false;
        }
    });

    $('input[name="searchHotelRate"]').on('keyup', function () {
        checkValidFloat(this);
    });

    $('input[name="searchMinMoney"]').on('keyup', function () {
        checkValidNumber(this);
    });

    $('input[name="searchMaxMoney"]').on('keyup', function () {
        checkValidNumber(this);
    });

}

$(function () {
    eventRegist();

    setDatetimepickerSetting();

    calculateDayJjw();

    owlSearch();
});