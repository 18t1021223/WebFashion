<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<title>Giỏ hàng</title>

<!-- MAIN-CONTENT-SECTION START -->
<section class="main-content-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- BSTORE-BREADCRUMB START -->
                <div class="bstore-breadcrumb">
                    <a href="<c:url value='/home'/>">Trang chủ</a>
                    <span><i class="fa fa-caret-right"></i></span>
                    <span>Giỏ hàng</span>
                </div>
                <!-- BSTORE-BREADCRUMB END -->
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- SHOPPING-CART SUMMARY START -->
                <h2 class="page-title">Giỏ hàng của tôi 
                	<span class="shop-pro-item">tổng sản phẩm: ${cart.size() }</span>
                </h2>
                <!-- SHOPPING-CART SUMMARY END -->
            </div>
			<c:if test="${cart.size()>0 }">
	            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style='padding:0;'>
	                <!-- SHOPING-CART-MENU START -->
	                <div class="shoping-cart-menu">
	                    <ul class="step">
	                        <li class="step-current first">
	                            <span>01. Giỏ hàng</span>
	                        </li>
	                        <li class="step-todo second">
	                            <span>02. Địa chỉ</span>
	                        </li>
	                        <li class="step-todo last" id="step_end">
	                            <span>03. Thanh toán</span>
	                        </li>
	                    </ul>
	                </div>
	                <!-- SHOPING-CART-MENU END -->
	                <!-- CART TABLE_BLOCK START -->
	                <div class="table-responsive">
	                    <!-- TABLE START -->
	                    <table class="table table-bordered" id="cart-summary">
	                        <!-- TABLE HEADER START -->
	                        <thead>
	                        <tr>
	                            <th class="cart-product">Sản phẩm</th>
	                            <th class="cart-description">Mô tả</th>
	                            <th class="cart-unit text-left">Giá</th>
	                            <th class="cart_quantity text-center">Số lượng</th>
	                            <th class="cart-total text-right">Tổng</th>
	                            <th class="cart-delete">&nbsp;</th>
	                        </tr>
	                        </thead>
	                        <!-- TABLE HEADER END -->
	                        <!-- TABLE BODY START -->
	                        <tbody id="tbody">
	                        <c:forEach var="item" items="${cart}" varStatus="index">
	                        	<c:set value="${item.value }" var="value"/>
	                        	<!-- SINGLE CART_ITEM START -->
		                        <tr>
		                            <td class="cart-product">
		                                <a href="<c:url value='/product/info/${value.prod.productId }'/>"><img alt="Blouse" src="<c:url value='/assets/user/img/product/${ value.prod.productImage }'/>"></a>
		                            </td>
		                            <td class="cart-description">
		                                <p class="product-name"><a href="<c:url value='/product/info/${value.prod.productId }'/>">${value.prod.productName }</a></p>
		                                <span> 
			                                <c:if test="${item.key.sizeId >0}">
			                                	Size: ${value.prod.sizes.get(0).sizeName }
			                                </c:if>
			                                <c:if test="${item.key.colorId >0  }">
			                               		 ,
			                                	Màu: ${value.prod.colors.get(0).colorName }
			                                </c:if> 
			                             </span>
		                            </td>
		
		                            <td class="cart-unit">
		                                <ul class="price text-left">
		                                    <li class="price special-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${value.prod.productPrice-value.prod.productDiscount }"/></li>
		                                    <c:if test="${value.prod.productDiscount >0 }">
			                                    <li class="price-percent-reduction small">
			                                    	-<fmt:formatNumber type='number' maxFractionDigits="0" value="${100-((value.prod.productPrice-value.prod.productDiscount)/value.prod.productPrice*100) }"/>%
			                                    </li>
			                                    <li class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${value.prod.productPrice}"/></li>
		                                    </c:if>
		                                </ul>
		                            </td>
		                            <td class="cart_quantity text-center">
		                                <input type="number" class="see-more-btn single-product-qty" name="quantity"  min="1" value='${ value.quantity}' max="20" autocomplete="off" data-id="${item.key.productId}-${item.key.sizeId}-${item.key.colorId}">
		                            </td>
		                            <td class="cart-total">
		                                <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${value.totalPrice }"/></span>
		                            </td>
		                            <td class="cart-delete text-center">
		                                <a href="" class="cart_quantity_delete" data-id="${item.key.productId}-${item.key.sizeId}-${item.key.colorId}" title="Xóa sản phẩm"><i class="fa fa-trash-o"></i></a>
		                            </td>
		                        </tr>
		                        <!-- SINGLE CART_ITEM END -->
	                        </c:forEach>
	                        </tbody>
	                        <!-- TABLE BODY END -->
	                        <!-- TABLE FOOTER START -->
	                        <tfoot>
	                        <tr>
	                            <td class="total-price-container text-right" colspan="4">
	                                <span>Tổng tiền hàng</span>
	                            </td>
	                            <td id="total-price-container" class="price" colspan="2">
	                                <span id="total-price"><fmt:formatNumber type='currency' currencySymbol="₫" maxFractionDigits="0" value="${totalPriceCart }"/></span>
	                            </td>
	                        </tr>
	                        </tfoot>
	                        <!-- TABLE FOOTER END -->
	                    </table>
	                    <!-- TABLE END -->
	                </div>
	                <!-- CART TABLE_BLOCK END -->
	            </div>
			</c:if>
			<c:if test="${cart.size()==0 }">
				<img alt="Giỏ hàng rỗng" src="<c:url value='/assets/user/img/cart/empty_cart.png'/>" class="empty_cart-center" title="Chưa có sản phẩm.">				
			</c:if>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- RETURNE-CONTINUE-SHOP START -->
                <div class="returne-continue-shop">
                    <a href="<c:url value='/home'/>" class="continueshoping"><i class="fa fa-chevron-left"></i>Tiếp tục mua sắm</a>
                    <c:if test="${cart.size() > 0}">
                    	<a href="<c:url value='/cart/checkout-address'/>" class="procedtocheckout">Tiến hành thanh toán<i class="fa fa-chevron-right"></i></a>
                    </c:if>
                </div>
                <!-- RETURNE-CONTINUE-SHOP END -->
            </div>
        </div>
    </div>
</section>
<!-- MAIN-CONTENT-SECTION END -->