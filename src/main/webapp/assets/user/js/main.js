(function ($) {
    "use strict";

    $(document).ready(function () {
        /*---------------------------------------
        	curency and language js
        ----------------------------------------- */
        $(".current-currency").on("click", function () {
            $(".currency-toogle").slideToggle(400);
        });
        $(".current-lang").on("click", function () {
            $(".language-toogle").slideToggle(400);
        });

        /*---------------------------------------
        	price range ui slider js
        ----------------------------------------- */
        $("#price-range").slider({
            range: true,
            min: 1,
            max: 100,
            values: [10, 90],
            slide: function (event, ui) {
                $("#slidevalue").val("$" + ui.values[0] + " - $" + ui.values[1]);
            }
        });
        $("#slidevalue").val("$" + $("#price-range").slider("values", 0) +
            " - $" + $("#price-range").slider("values", 1));

        /*---------------------------------------
        	scroll to top
        ----------------------------------------- */
        $(window).scroll(function () {
            if ($(this).scrollTop() > 250) {
                $('.bstore-scrollertop').fadeIn();
            } else {
                $('.bstore-scrollertop').fadeOut();
            }
        });
        //Click event to scroll to top
        $('.bstore-scrollertop').on("click", function () {
            $('html, body').animate({scrollTop: 0}, 800);
            return false;
        });

        /*---------------------------------------
        	mobile menu
        ----------------------------------------- */
        $('.mobile-menu').meanmenu();

        /*---------------------------------------
        	new  product, sale product carousel
        ----------------------------------------- */
        $('.new-pro-carousel, .sale-carousel').owlCarousel({
            items: 2,
            itemsDesktop: [1199, 2],
            itemsDesktopSmall: [991, 1],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	featured  product, bestseller, carousel
        ----------------------------------------- */
        $('.feartured-carousel, .bestseller-carousel').owlCarousel({
            items: 5,
            itemsDesktop: [1199, 4],
            itemsDesktopSmall: [991, 3],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	related-product  carousel
        ----------------------------------------- */
        $('.related-product').owlCarousel({
            items: 4,
            itemsDesktop: [1199, 4],
            itemsDesktopSmall: [991, 3],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	latest news carousel
        ----------------------------------------- */
        $('.latest-news-carousel').owlCarousel({
            items: 4,
            itemsDesktop: [1199, 3],
            itemsDesktopSmall: [991, 3],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	client carousel
        ----------------------------------------- */
        $('.client-carousel').owlCarousel({
            items: 6,
            itemsDesktop: [1199, 4],
            itemsDesktopSmall: [991, 3],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });
        /*---------------------------------------
        	home 2 left category menu
        ----------------------------------------- */
        $('.category-heading').on("click", function () {
            $('.category-menu-list').slideToggle(300);
        });

        /*---------------------------------------
        	home 2 new product, home 2 sale product carousel
        ----------------------------------------- */
        $('.home2-new-pro-carousel, .home2-sale-carousel').owlCarousel({
            items: 4,
            itemsDesktop: [1199, 3],
            itemsDesktopSmall: [991, 2],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	sidebar best seller carousel
        ----------------------------------------- */
        $('.sidebar-best-seller-carousel').owlCarousel({
            items: 1,
            itemsDesktop: [1199, 1],
            itemsDesktopSmall: [991, 1],
            itemsTablet: [767, 1],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	tab product carousel	
        ----------------------------------------- */
        $('.tab-carousel-1, .tab-carousel-2, .tab-carousel-3').owlCarousel({
            items: 4,
            itemsDesktop: [1199, 4],
            itemsDesktopSmall: [991, 3],
            itemsTablet: [767, 2],
            itemsMobile: [480, 1],
            autoPlay: false,
            stopOnHover: false,
            navigation: true,
            pagination: false,
            navigationText: ['<i class="fa fa-angle-left owl-prev-icon"></i>', '<i class="fa fa-angle-right owl-next-icon"></i>']
        });

        /*---------------------------------------
        	mainSlider
        ----------------------------------------- */
        $('#mainSlider').nivoSlider({
            controlNav: true,
            directionNav: false,
            pauseTime: 5000,
            nextText: '<div class="slider-bolut"></div>',
            prevText: '<div class="slider-bolut"></div>'

        });

        /*---------------------------------------
        	single product product thumbnail
        ----------------------------------------- */
        $('.bxslider').bxSlider({
            minSlides: 3,
            maxSlides: 5,
            slideWidth: 88,
            responsive: true,
            prevText: '<i class="fa fa-angle-right"></i>',
            nextText: '<i class="fa fa-angle-left"></i>'
            
        });

        /*---------------------------------------
        	francy box lightbox
        ----------------------------------------- */
        $(".fancybox").fancybox();

        /*-----------------------------------------
        	ajax custom
        --------------------------------------------*/
        /* TIỀN TỆ :*/
        var currency = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'})
        /* TIỀN TỆ :*/

        function ajaxProductList(categoryId, orderBy, page, pageSize, productStatus ,keywordSearch) {
             $('<div class="modal-loading">'
                +'<div class="modal-loading-body">'
                +'<img src="/assets/user/img/ajax-loader.gif" class="loading-icon" alt="loading">'
                +'</div>'
                +'</div> ').appendTo('body')
            $.ajax({
                url: '/ajax/product/category',
                type: 'get',
                contentType: "application/json",
                dataType: 'json',
                data: {
                    categoryId: categoryId,
                    orderBy: orderBy,
                    page: page,
                    pageSize: pageSize,
                    productStatus: productStatus,
                    keywordSearch: keywordSearch
                }
            }).done(function (result) {

                let products = result.products  // MẢNG SẢN PHẨM
                /*Chinh sua san pham*/
                let url = '/product/info/'
                let prod = ""
                let productsSize = products.length;
                for (let i = 0; i < productsSize; i++) {
                    prod += ' <li class="gategory-product-list col-lg-3 col-md-4 col-sm-6 col-xs-12"> ' +
                        '<div class="single-product-item">' +
                        '<div class="product-image">' +
                        '	<a href="'+ url + products[i].productId +'"> ' +
                        '		<img src="/assets/user/img/product/sale/' + products[i].productImage + ' " alt="product-image" />' +
                        '</a>'
                    if (products[i].productDiscount > 0) {
                        prod += '<a href="'+ url + products[i].productId   
                            + '" class="new-mark-box">- ' + Math.round(100 - ((products[i].productPrice - products[i].productDiscount) / products[i].productPrice * 100)) + '%</a>'
                    }
                    prod += '<div class="overlay-content">' +
                        '    <ul>' +
                        '        <li><a href="'+url + products[i].productId +'" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li> ' + 
                        '   </ul>' +
                        '</div>' +
                        '</div>' +
                        '<div class="product-info">' +
                        '   <a href="'+ url + products[i].productId +'" class="product-name-text">' + products[i].productName + '</a>' +
                        '    <div class="price-box">' +
                        '       <span class="price">' + currency.format(products[i].productPrice - products[i].productDiscount) + '</span>'

                    if (products[i].productDiscount > 0) {
                        prod += ' <span class="old-price">' + currency.format(products[i].productPrice) + '</span>'
                    }
                    prod += '   </div>' +
                        '</div>' +
                        '</div>' +
                        '</li>'
                }
                $('.gategory-product').html(prod)

                /*==TỔNG SÓ LƯƠNG SẢN PHẨM==*/
                $('.count-product').html('Có ' + result.totalProduct + ' sản phẩm.')

                /*==THANH LINK==*/
                let categoryDtos = result.categoryDto;
                let link = '<a href="/home">Trang chủ</a>'
                for (let i = 0; i < categoryDtos.length; i++) {
                    link += '<span> <i class="fa fa-caret-right"></i> </span>' +
                        '<span style="cursor: pointer;" class="Subcategory" data-categoryid=' + categoryDtos[i].categoryId + '>' + categoryDtos[i].categoryName + '</span>'
                }
                $('.bstore-breadcrumb').html(link)

                /*==THÔNG TIN DANH MỤC ĐANG CHỌN==*/
                let parent = categoryDtos[categoryDtos.length - 1];
                if(parent == null){
                    $('#parent').data('categoryid', 0)
                    $('#parent').text('Tất cả sản phẩm')

                }else{
                    $('#parent').data('categoryid', parent.categoryId)
                    $('#parent').text(parent.categoryName)
                }

                /*==Danh mục con==*/
                let subCategoriesDto = result.subCategoriesDto;
                if (subCategoriesDto.length > 0) {
                    let sub = ''
                    for (let i = 0; i < subCategoriesDto.length; i++) {
                        sub += '<li class="category-li"><i class="fa fa-angle-right"></i>' +
                            '<a href="" data-categoryid=' + subCategoriesDto[i].categoryId + '>' + subCategoriesDto[i].categoryName + '</a>' +
                            '</li>'
                    }
                    $('.product-single-sidebar-ul').html(sub)
                    if (parent ==null)
                        $('.product-single-sidebar-ul').find("[data-categoryid=0]").addClass('category-select')
                    else
                        $('.product-single-sidebar-ul').find("[data-categoryid=" + parent.categoryId + "]").addClass('category-select')
                }

                /*==NARVIGATION==*/
                let pagination = result.pag
                $(".showing-item").html('<span>Trang ' + pagination.page + '/' + pagination.totalPage + '</span>')
                let showing = '<li '
                if (pagination.page == 1)
                    showing += ' class=disabled '
                showing += '><a class="direction" href="#" data-page='+ (pagination.page - 1)+'><i class="fa fa-chevron-left"></i></a> </li>'
                for (let i = pagination.start; i <= pagination.end; i++) {
                    showing += '<li'
                    if (pagination.page == i)
                        showing += ' class="active disabled" data-page=' + i
                    showing += '><span><a class="pagi-num" href="#" data-page=' + i + '> ' + i + '</a></span></li>'
                }
                showing += '<li '
                if ( pagination.page == pagination.end)
                    showing += ' class=disabled '
                showing += '><a class="direction" href="#" data-page='+(pagination.page + 1)+'><i class="fa fa-chevron-right"></i></a></li>'

                $('.pagination-bar').html(showing)

                /*===keywordSearch===*/
                $('select[name=categoryid]').val( categoryDtos[ categoryDtos.length-1 ].categoryId )
                $('input[name=keywordSearch]').val(result.keywordSearch)
            }).fail(function (jqXHR, errorThrown) {
                func_error()
            }).always(function(){
                $('.modal-loading').remove()
            })
        }

        /*========================THAY ĐỔI LỊCH SỬ===============*/
        function replaceHistory(categoryId, orderBy, page ,keywordSearch) {
            let urlCurrent = '/product/category?categoryId=' + categoryId + '&orderBy=' + orderBy + '&page=' + page +'&keywordSearch='+keywordSearch 
            let historyString = window.location.search+''
            if ( ('?categoryId=' + categoryId + '&orderBy=' + orderBy + '&page=' + page+'&keywordSearch='+keywordSearch) != historyString)
                window.history.pushState(history.scrollRestoration, null, window.location.href)
            window.history.replaceState(history.scrollRestoration, null, urlCurrent)
        }

        /*======================== SẮP XẾP =======================*/
        $('body').delegate('#sortBy' , 'change' , function () {
            let categoryId = $('#parent').data('categoryid')
            let orderBy = $(this).val()
            let page = $('.pagination-bar').find('.active').data('page')
            let pageSize = 16
            let productStatus = true
            let keywordSearch = $('input[name=keywordSearch]').val()
            ajaxProductList(categoryId, orderBy, page, pageSize, productStatus ,keywordSearch)
            replaceHistory(categoryId ,orderBy ,page ,keywordSearch)
        })

        /*======================= DANH MỤC=======================*/
        $('body').delegate('.category-li','click' ,function (e) {
            e.preventDefault()
            let categoryId = $(this).find('a').data('categoryid')
            let orderBy = $('#sortBy').find(':selected').val()
            let page = $('.pagination-bar').find('.active').data('page')
            let pageSize = 16
            let productStatus = true
            let keywordSearch = $('input[name=keywordSearch]').val()
            ajaxProductList(categoryId, orderBy, page, pageSize, productStatus , keywordSearch)
            replaceHistory(categoryId ,orderBy ,page ,keywordSearch)
        })

        /*=====================THANH LINK=========================*/
        $('body').delegate('.Subcategory' ,'click' , function () {
            window.location = '/product/category?categoryId=' + $(this).data('categoryid')
          //  replaceHistory(categoryId)
        })

        /*====================NAVIGATION==========================*/
        $('body').delegate('.direction' ,'click' ,function (e) {
            e.preventDefault()
            let isLock = $(this).parent().hasClass('disabled')
            if (isLock == false) {
                let categoryId = $('#parent').data('categoryid')
                let orderBy = $('#sortBy').find(':selected').val()
                let page = $(this).data('page')
                let pageSize = 16
                let productStatus = true
                let keywordSearch = $('input[name=keywordSearch]').val()
                $('.bstore-scrollertop').click();
                ajaxProductList(categoryId, orderBy, page, pageSize, productStatus ,keywordSearch)
                replaceHistory(categoryId ,orderBy,page ,keywordSearch)                
            }
        })

        $('body').delegate('.pagi-num' ,'click' , function (e) {
            e.preventDefault();
            let isLock = $(this).parents('li').hasClass('disabled')
            if(isLock == true) return;
            let categoryId = $('#parent').data('categoryid')
            let orderBy = $('#sortBy').find(':selected').val()
            let page = $(this).data('page')
            let pageSize = 16
            let productStatus = true
            let keywordSearch = $('input[name=keywordSearch]').val()
            $('.bstore-scrollertop').click();
            ajaxProductList(categoryId, orderBy, page, pageSize, productStatus ,keywordSearch)     
            replaceHistory(categoryId ,orderBy ,page ,keywordSearch)
        })

        /*===LOAD LAI TRANG KHI BACK - GO ===*/
        $(window).on("popstate", function (e) {
           location.reload()
        });
    });
	
	/*===THÊM VÀO GIỎ HÀNG START===*/
    $('.add-cart-submit').click(function(e) {
    	$('#error').remove()
    	// NẾU TỒN TẠI INPUT CÓ NAM SIZEID
    	if ( $('input[name="sizeId"]').length  && $('input[name="colorId"]').length  ){
    		if ($('input[name="sizeId"]:checked').val() == undefined || $('input[name="colorId"]:checked').val() == undefined) {
	            e.preventDefault()
	            $(this).before("<p id='error'>Vui lòng điền đầy đủ thông tin phân loại hàng!</p>")
	            return
    		}
        }else if( $('input[name="sizeId"]').length ){
        	if ($('input[name="sizeId"]:checked').val() == undefined) {
	            e.preventDefault()
	            $(this).before("<p id='error'>Vui lòng điền đầy đủ thông tin phân loại hàng!</p>")
	            return
    		}
        }else if( $('input[name="colorId"]').length ){
        	if ( $('input[name="colorId"]:checked').val() == undefined) {
	            e.preventDefault()
	            $(this).before("<p id='error'>Vui lòng điền đầy đủ thông tin phân loại hàng!</p>")
	            return
    		}
        }
        $('#form-order').submit(function(e) {
            e.preventDefault()
            $('<div class="modal-loading">'
                +'<div class="modal-loading-body">'
                +'<img src="/assets/user/img/ajax-loader.gif" class="loading-icon" alt="loading">'
                +'</div>'
                +'</div> ').appendTo('body')
            $.ajax({
            	url : '/cart/addCart',
                type: 'get',
                dataType: 'html',
                data:  $(this).serialize()  
            }).done(function(data){
                window.location.reload()
                $('.modal-loading').remove()
            }).fail(function(a,b){
            	func_error()
            })
        })   
    })
    /*===THÊM VÀO GIỎ HÀNG END===*/    
    /*===SỬA GIỎ HÀNG START===*/
    $(".cart_quantity .single-product-qty").change(function(e){
    	 let data = $(this).data("id").split("-")
    	 let qty = $(this).val();
    	  if(qty <0 || qty >20 || Number.isInteger(Number.parseInt(qty))==false || Number.isInteger( qty - Number.parseInt(qty) ) ==false){
    	      $(this).val(1)
    	      qty =1
    	  }
		  $.ajax({
	    		url:'/cart/editCart',
	    		type:'get',
	    		dataType:'html',
	    		data:{
	    			productId : data[0],
	    			sizeId : data[1],
	    			colorId :data[2],
	    			quantity : qty
	    		}
	    	}).done(function(data){
	    		window.location.reload();
	    	}).fail(function(a,b){
	    		func_error()
	        })
    })
    /*===SỬA GIỎ HÀNG END===*/
    /*===XOA GIỎ HÀNG START===*/
    $('.cart_quantity_delete').click(function(e){
    	e.preventDefault()
    	let data = $(this).data('id').split('-')
    	data.forEach(function(e){
    		let rs = Number.isInteger( Number.parseInt(e) )
    		if(  rs ==false || rs < 0  )
    			return
		})
		$.ajax({
	    		url:'/cart/deleteCart',
	    		type:'get',
	    		dataType:'html',
	    		data:{
	    			productId : data[0],
	    			sizeId : data[1],
	    			colorId :data[2]
	    		}
	    	}).done(function(data){
	    		window.location.reload();
	    	}).fail(function(a,b){
	    		func_error()
	        })
    })
    /*===XOA GIỎ HÀNG END===*/
    
    /*AJAX GIỎ HÀNG START*/
    function modifyCart(ajax){
    	var currency = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'})
    	let json = JSON.parse(ajax)
    	let text = ""
    	let totalPrice = 0
    	let i = 0 
    	let discount_Index = 0
    	//XÓA element

    	$('.table-responsive').remove()
    	// KIỂM TRA CART RỖNG K   true = rong
    	let booleanEmpty = jQuery.isEmptyObject(ajax)
    	if( booleanEmpty  == false ){
    		$(".shoping-cart-menu").add('<div class="table-responsive"></div>').insertAfter('.shoping-cart-menu')
    		$('.table-responsive').add('<table class="table table-bordered" id="cart-summary"></table>').appendTo('.table-responsive')
    		$('<thead><tr>'
                    +'<th class="cart-product">Sản phẩm</th>'
                    +'<th class="cart-description">Mô tả</th>'
                    +'<th class="cart-unit text-left">Giá</th>'
                    +'<th class="cart_quantity text-center">Số lượng</th>'
                    +'<th class="cart-total text-right">Tổng</th>'
                    +'<th class="cart-delete">&nbsp;</th></tr></thead>').appendTo('#cart-summary')
            $('<tbody id="tbody"></tbody>').appendTo('#cart-summary')        
            $('<tfoot><tr>'
                    +'<td class="total-price-container text-right" colspan="4">'
                    +'    <span>Tổng tiền hàng</span>'
                    +'</td>'
                    +'<td id="total-price-container" class="price" colspan="2">'
                    +'    <span id="total-price"></span>'
                    +'</td></tr></tfoot>').appendTo('#cart-summary')        	
    	}
    	
    	for (const [key, value] of Object.entries(json)) {
    		totalPrice += value.totalPrice
    		let keyId = key.split('-')
    		let span = ''
    		if( keyId[1] > 0){
    			span+= 'Size: '+ value.prod.sizes[0].sizeName
    		}
    		if( keyId[2] > 0){
    			span+=', Màu: '+ value.prod.colors[0].colorName
    		}
        	
        	$('<tr></tr>').appendTo('#tbody')
        	$('<td class="cart-product"></td>').appendTo('#tbody tr:eq('+ i +')')
        	$('<a href="/product/info/'+ value.prod.productId +'"><img alt="Blouse" src="/assets/user/img/product/'+ value.prod.productImage +'"></a>').appendTo('#tbody .cart-product:eq('+ i +')')
        	$('<td class="cart-description"></td>').appendTo('#tbody tr:eq('+ i +')')
        	$('<p class="product-name"></p>').appendTo('#tbody .cart-description:eq('+ i +')')
        	$('<a href="/product/info/'+ value.prod.productId +'">'+ value.prod.productName +'</a>').appendTo('#tbody .product-name:eq('+ i +')')
        	$('<span>'+ span +'</span>').appendTo('#tbody .cart-description:eq('+ i +')')
        	$('<td class="cart-unit"></td>').appendTo('#tbody tr:eq('+ i +')')
        	$('<ul class="price text-left"></ul>').appendTo('#tbody .cart-unit:eq('+ i +')')
        	$('<li class="price special-price">'+ currency.format(value.prod.productPrice-value.prod.productDiscount) +'</li>').appendTo('.price.text-left:eq('+ i +')')
        	if( value.prod.productDiscount >0 ){
        		$('<li class="price-percent-reduction small">-'+ Math.round(100-((value.prod.productPrice-value.prod.productDiscount)/value.prod.productPrice*100)) +'%</li>').appendTo('.price.text-left:eq('+ i +')')
        		$('<li class="old-price">'+ currency.format(value.prod.productPrice) +'</li>').appendTo('.price.text-left:eq('+ i +')')
        	}
        	$('<td class="cart_quantity text-center"></li>').appendTo('#tbody tr:eq('+ i +')')
        	$('<input type="number" class="see-more-btn single-product-qty" name="quantity"  min="1" value="'+ value.quantity +'" max="100" autocomplete="off" data-id="'+ key +'">').appendTo('#tbody .cart_quantity.text-center:eq('+ i +')')
    		$('<td class="cart-total"></td>').appendTo('#tbody tr:eq('+ i +')')
    		$('<span class="price">'+ currency.format(value.totalPrice)+'</span>').appendTo('#tbody .cart-total:eq('+ i +')')
    		$('<td class="cart-delete text-center"></td>').appendTo('#tbody tr:eq('+ i +')')
    		$('<a href="" class="cart_quantity_delete" data-id="'+ key +'" title="Xóa sản phẩm"><i class="fa fa-trash-o"></i></a>').appendTo('#tbody .cart-delete.text-center:eq('+ i +')')		
    		i++;
    	}
    	if(i > 0 ){
    		let j = 0;
	    	for (const [key, value] of Object.entries( json )) {
	    		//CẬP NHẬT ICON GIỎ HÀNG
	    		if( j <=2 ){
	    			$('.shipping-cart-overly').add('<div class="shipping-item"></div>').appendTo('.shipping-cart-overly')
		    		$('.shipping-item:eq('+ i +')').add('<div class="shipping-item-image"></div>').appendTo('.shipping-item:eq('+ i +')')
		    		$('.shipping-item-image:eq('+ i +')').add('<a href=""></a>').appendTo('.shipping-item-image:eq('+ i +')')
		    		$('.shipping-item-image:eq('+ i +') a').add('<img src="" alt="image" width="80" />').appendTo('.shipping-item-image:eq('+ i +') a')
		    		$('.shipping-item:eq('+ i +')').add('<div class="shipping-item-text"></div>').appendTo('.shipping-item:eq('+ i +')')
		    		$('.shipping-item-text:eq('+ i +')').add('<a href="" class="pro-cat product-name-text"></a>').appendTo('.shipping-item-text:eq('+ i +')')
		    		$('.shipping-item-text:eq('+ i +')').add('<span></span>').appendTo('.shipping-item-text:eq('+ i +')')
		    		//CHÈN DỮ LIỆU
	    			$('.shipping-item-image a').eq(i).attr('href','/product/info/'+ value.prod.productId)
	    			$('.shipping-item-image a img').eq(i).attr('src', '/assets/user/img/product/'+ value.prod.productImage)
	    			$('.shipping-item-text span').eq(i).text(value.quantity +' x '+ currency.format(value.prod.productPrice - value.prod.productDiscount ))
	    			$('.pro-cat.product-name-text').eq(i).text(value.prod.productName)
	    			$('.pro-cat.product-name-text').eq(i).attr( 'href','/product/info/'+value.prod.productId )
	    		}
	    		j++;
	    	}
	    	$('.ajax-cart-quantity').text((i))
    		$('.shipping-total').text( currency.format(totalPrice) )
    	}else{
    		$('.ajax-cart-quantity').text('')
    		$('.shipping-total').text( '')
    	}
    	$('#total-price').text(currency.format(totalPrice))
    	$('.shop-pro-item').text("tổng sản phẩm: "+(i))
    	window.location.reload();
    }
    /*AJAX GIỎ HÀNG END*/
    
    /*=== LOAD TRANG START===*/
    window.addEventListener( "pageshow", function ( event ) {
        let historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
        if ( historyTraversal ) {
          // Handle page restore.
          window.location.reload();
        }
   });
    /*=== LOAD TRANG END===*/
    /*=== ERROR START===*/
    function func_error(){
        alert('Có lỗi xảy ra, vui lòng thử lại sau!')
        window.location.reload();
    }
    /*=== ERROR END ===*/
    /*=== CHECK ADDRESS START===*/
    $('.address.procedtocheckout').click(function(e){
        $('.check-error').remove()
    	e.preventDefault();
    	if( $('#province').val() <=0 )
            $("<span class='check-error'>Vui lòng chọn thông tin.</span>").insertAfter('#province')
        if( $('#district').val() <=0 )
            $("<span class='check-error'>Vui lòng chọn thông tin.</span>").insertAfter('#district')
        if( $('#ward').val() <=0 && $('#ward').text() != '' )
            $("<span class='check-error'>Vui lòng chọn thông tin.</span>").insertAfter('#ward')
        if( $('#province').val() >0 && 
            $('#district').val() >0 &&
            (( $('#ward option').length >1 && $('#ward').val() >0) || $('#ward').text()=='' ) )         	     
            $('#info-address').submit() 	
    })
    $("#province").change(function(){
        var temp = this.value;
        $.ajax({
            url : '/cart/district',
            type : 'get',
            dataType : 'html',
            data : {
                provinceId : temp
            }
        }).done(function(data) {
            let text ="<option hidden value=''>Quận/huyện *</option>"
            try{
                for (const [key, value] of Object.entries(JSON.parse(data))) {
                    text+= "<option value='"+value.districtId+"'>"+value.districtName+"</option>"
                }
                $('#district').html(text);
                $('#ward').val('');
            }catch(e){
                func_error()
            }
        }).fail(function(){
            func_error()
        });
    })

    $("#district").change(function(){
        let temp = this.value;
        $.ajax({
            url : '/cart/ward',
            type : 'get',
            dataType : 'html',
            data : {
                districtId : temp
            }
        }).done(function(data) {
            if(jQuery.isEmptyObject(JSON.parse(data))){
                $('#ward').html("<option hidden value='0'></option>");
                return
            }
            let text ="<option hidden value=''>Phường/Xã *</option>"
            try{
                for (const [key, value] of Object.entries(JSON.parse(data))) {
                    text+= "<option value='"+value.wardId+"'>"+value.wardName+"</option>"
                }
                $('#ward').html(text);
            }catch(e){
                func_error()
            }
        }).fail(function(){
            func_error()
        });
    }) 
    /*=== CHECK ADDRESS END===*/

    /*=== PAYMENT SELECT START ===*/
    $('input[name=payment]').parent('label').css('border','')
    $('input[name=payment]:checked').parent('label').css('border' ,'2px solid #ff4f4f')
    $('input[name=payment]').click(function(){
        $('input[name=payment]').parent('label').css('border','')
        $(this).parent('label').css('border' ,'2px solid #ff4f4f')
        payment = $(this).val()
    })
    /*=== PAYMENT SELECT END ===*/
    
    /*=== ADDRESS-DETAILS START===*/
    let payment = $('input[name="payment"]:checked').val()

    $('.order.procedtocheckout').click(function(e){
        $('<div class="modal-loading">'
        +'<div class="modal-loading-body">'
        +'<img src="/assets/user/img/ajax-loader.gif" class="loading-icon" alt="loading">'
        +'</div>'
        +'</div> ').appendTo('body')
    	e.preventDefault()
    	let uri = "/cart/order?payment="+payment
     //   const encoded = encodeURI(uri);
    	window.location = uri
    })
    /*=== ADDRESS-DETAILS END===*/
    
})(jQuery);

/*THANH THÔNG BÁO START*/
function dialog(number){
	
	if(number == 1){}
}
/*THANH THÔNG BÁO END*/
