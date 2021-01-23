<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>Chi tiết đơn hàng.</title> 

<!-- MAIN-CONTENT-SECTION START -->
<section class="main-content-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- BSTORE-BREADCRUMB START -->
                <div class="bstore-breadcrumb">
                    <a href="<c:url value='/home'/>">Trang chủ</a>
                    <span><i class="fa fa-caret-right"></i></span>
                    <span>Thanh toán</span>
                </div>
                <!-- BSTORE-BREADCRUMB END -->
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
                <h2 class="page-title">Phương thức thanh toán<span class="shop-pro-item">Tổng sản phẩm: ${cart.size() }</span></h2>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding:0;">
                <!-- SHOPING-CART-MENU START -->
                <div class="shoping-cart-menu">
                    <ul class="step">
                        <li class="step-todo first step-done">
                            <span><a href="<c:url value='/cart'/>">01. Giỏ hàng</a></span>
                        </li>
                        <li class="step-todo second step-done">
                             <span><a href="<c:url value='/cart/checkout-address'/>">02. Địa chỉ</a></span>
                        </li>
                        <li class="step-current last" id="step_end">
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
                            </tr>
                        </thead>
                        <!-- TABLE HEADER END -->
                        <!-- TABLE BODY START -->
                        <tbody>
                        	<c:forEach var="item" items="${cart }" >
                        		<c:set var="value" value="${item.value }"/>
	                            <!-- SINGLE CART_ITEM START -->
	                            <tr>
	                                <td class="cart-product">
		                                <a href="<c:url value='/product/info/${value.prod.productId }'/>">
		                                	<img alt="Blouse" src="<c:url value='/assets/user/img/product/${ value.prod.productImage }'/>">
		                                </a>
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
		                                <span>${value.quantity }</span>
		                            </td>
	                                <td class="cart-total">
		                                <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${value.totalPrice }"/></span>
		                            </td>
	                            </tr>
	                            <!-- SINGLE CART_ITEM END -->
                            </c:forEach>
                        </tbody>
                        <!-- TABLE BODY END -->
                        <!-- TABLE FOOTER START -->
                        <tfoot>
                            <tr class="cart-total-price">
                                <td class="text-right" colspan="3">Tạm tính</td>
                                <td id="total_product" class="price" colspan="2">
                                	<fmt:formatNumber type='currency' currencySymbol="₫" maxFractionDigits="0" value="${totalPriceCart }"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-right" colspan="3">Phí vận chuyển</td>
                                <td id="total_shipping" class="price" colspan="2">
                                    <p> <fmt:formatNumber type='currency' currencySymbol="₫" maxFractionDigits="0" value="${shippingCost.cost }"/></p>
                                <!--    <p>-25.000 đ</p> -->
                                </td>
                            </tr>
                            <tr>
                                <td class="total-price-container text-right" colspan="3">
                                    <span>Tổng tiền hàng</span>
                                </td>
                                <td id="total-price-container" class="price" colspan="2">
                                    <span id="total-price"  class='special-price'>
                                    	<fmt:formatNumber type='currency' currencySymbol="₫" maxFractionDigits="0" value="${totalPriceCart + shippingCost.cost }"/>
                                    </span>
                                </td>
                            </tr>
                        </tfoot>
                        <!-- TABLE FOOTER END -->
                    </table>
                    <!-- TABLE END -->
                </div>
                <!-- CART TABLE_BLOCK END -->
            </div>

            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" style="padding:0;"> 
                <!-- FOUR-PAYMENT-METHOD START -->
                <div class="four-payment-method">
                	<c:forEach var="item" items="${payments }" varStatus="index">
                		<!-- SINGLE-PAYMENT-METHOD START -->
	                    <div class="single-payment-method">
	                        <label>
	                        	<img src="<c:url value='/assets/user/img/${item.paymentImage }'/>" width="60px">
	                        	<c:if test="${index.index == 0 }">
	                        		<input checked="checked" hidden type="radio" name="payment" value="${item.paymentId }"> ${ item.paymentName }
	                        	</c:if>
	                        	<c:if test="${index.index != 0 }">
	                        		<input hidden type="radio" name="payment" value="${item.paymentId }"> ${ item.paymentName }
	                        	</c:if>
	                        </label>
	                    </div>
	                    <!-- SINGLE-PAYMENT-METHOD END -->
                	</c:forEach>
                </div>
                <!-- FOUR-PAYMENT-METHOD END -->
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="checkout-address">
                    <div class="checkout-address-header">
                        <h3 class="checkout-address-heading">Địa chỉ nhận hàng</h3>
                    </div>
                    <div class="checkout-address-body">
                        <div class="checkout-address-body__name">
                            <p>${addressSession.name }</p>
                        </div>
                        <div class="checkout-address-body__phone">
                            <p>${addressSession.phone }</p>
                        </div>
                        <div class="checkout-address-body__address">
                            <p>${addressSession.street},<c:if test="${addressSession.ward != null}"> ${addressSession.ward}, </c:if>${addressSession.district } ,${addressSession.province }</p>
                        </div>
                    </div>
                   
                </div>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <!-- RETURNE-CONTINUE-SHOP START -->
                <div class="returne-continue-shop">
                    <a href="<c:url value='/home'/>" class="continueshoping"><i class="fa fa-chevron-left"></i>Tiếp tục mua sắm</a>
                    <a href="" class="order procedtocheckout">Đặt hàng</a>
                </div>
                <!-- RETURNE-CONTINUE-SHOP END -->
            </div>
        </div>
    </div>
</section>
<!-- MAIN-CONTENT-SECTION END -->
