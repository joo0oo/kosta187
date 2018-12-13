function calculateDayJjw2(para1, para2) {
    const startDay = new Date($(para1).find('input').val());
    const endDay = new Date($(para2).find('input').val());
    if (endDay <= startDay) {
        startDay.setDate(startDay.getDate() + 1);
        $(para2).data("DateTimePicker").date(startDay);
    } else {
        const betweenDay = (endDay - startDay) / (1000 * 60 * 60 * 24);
        $(para1).closest('form').find('.betweenDay').html(`<strong>${betweenDay}박 ${betweenDay + 1}일</strong>`);
    }
}

function setDatetimepickerSetting() {
    $('.datetimepicker1').datetimepicker({
        locale: 'ko',
        format: 'YYYY-MM-DD',
        icons: {
            next: "fa fa-chevron-right",
            previous: "fa fa-chevron-left",
        },
        defaultDate: 'now'
    });

    $('.datetimepicker2').datetimepicker({
        useCurrent: false, //Important! See issue #1075
        locale: 'ko',
        format: 'YYYY-MM-DD',
        icons: {
            next: "fa fa-chevron-right",
            previous: "fa fa-chevron-left",
        },
        defaultDate: 'tomorrow'
    });
    $(".datetimepicker1").on("dp.change", function (e) {
    	const dtp2 = $(this).closest('form').find('.datetimepicker2');
        $(dtp2).data("DateTimePicker").minDate(e.date);
        calculateDayJjw2(this, dtp2);
    });
    $(".datetimepicker2").on("dp.change", function (e) {
    	const dtp1 = $(this).closest('form').find('.datetimepicker1');
    	$(dtp1).data("DateTimePicker").maxDate(e.date);
        calculateDayJjw2(dtp1,this);
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
	//console.log(element);
	//console.log($(element).next().val());
    const beforeValue = parseInt($(element).next().val());
    const thisValue = parseInt(element.value);
    console.log('before:'+beforeValue);
    console.log('thisValue:'+thisValue);
    
    if (beforeValue < thisValue) {
        for (let i = beforeValue + 1; i <= thisValue; i += 1) {
            $(element).closest('form').find('[id^="roomNumberAnchor"]').append(addsearchPersonNumber('input-lg'));
        }
    } else if (beforeValue > thisValue) {
        for (let i = beforeValue; i > thisValue; i -= 1) {
            for (let j = 0; j < 2; j += 1) {
            	$(element).closest('form').find('[id^="roomNumberAnchor"]').children().last().remove();
            }
        }
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

function sjhInit(element) {
    console.log('sjhInit');
	
    $('[id^="roomNumber-wishlist-"]').on('mousedown', function () {
    	console.log('onmousedown called');
        $(this).next().val(parseInt(this.value));
    });

    $('[id^="roomNumber-wishlist-"]').on('change', function (e) {
    	console.log('onchange changeRoomNumberJjw called');
        changeRoomNumberJjw(this);
    });
    
    
    $('[id^="roomNumber2-lastview-"]').on('mousedown', function () {
    	console.log('onmousedown called');
        $(this).next().val(parseInt(this.value));
    });

    $('[id^="roomNumber2-lastview-"]').on('change', function (e) {
    	console.log('onchange changeRoomNumberJjw called');
        changeRoomNumberJjw(this);
    });
}

function eventRegist() {

    $('.modal').on('show.bs.modal', function () {
        window.dispatchEvent(new Event('resize'));
    });

    $('.modal').on('shown.bs.modal', function () {
        setTimeout(() => {
            $(this).find('.owl-carousel').trigger('prev.owl.carousel')
            $(this).find('.owl-carousel').trigger('prev.owl.carousel')
        }, 300);
    });

    $('.roomSelect').on('click', function () {
        initButtons(this);
        addRoomInfo(this);
    });

    $('.reservationButton').on('click', function () {
        addHotmlRoomInfo(this);
    });
}

$(function () {
	sjhInit();
	
    eventRegist();

    setDatetimepickerSetting();

    calculateDayJjw();

    owlSearch();
});