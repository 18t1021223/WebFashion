<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 

<!-- HEADER-TOP END -->
<!-- HEADER-MIDDLE START -->
<section class="header-middle">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <!-- LOGO START -->
                <div class="logo">
                    <a href="<c:url value="/home"/>"><img src="<c:url value='/assets/user/img/logo2.png'/>" alt="logo" /></a>
                </div>
                <!-- LOGO END -->

                <!-- CATEGORYS-PRODUCT-SEARCH START -->
                <div class="categorys-product-search">
                    <form action="/product/category" method="get" class="search-form-cat">
                        <div class="search-product form-group">
                            <select name="categoryId" class="cat-search">
                                    <option value="0">Tất cả</option>
                                    <c:forEach var="item" items="${categorySearch}">
                                    	<option value="${item.categoryId }">
                                    		<c:forEach var="d" begin='1' end="${item.level }">
                                    			<c:out value="-"/>
                                    		</c:forEach>
                                    		<c:out value=" ${item.categoryName}"/>
                                    	</option>
                                    </c:forEach>							
                                </select>
                            <input  type="text" class="form-control search-form" name="keywordSearch" placeholder="Từ khóa tìm kiếm... " autocomplete="on"/>
                            <button class="search-button" value="Search" type="submit">
                                    <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <!-- CATEGORYS-PRODUCT-SEARCH END -->
            </div>
        </div>
    </div>
</section>
<!-- HEADER-MIDDLE END -->
<!-- MAIN-MENU-AREA START -->
<header class="main-menu-area">
    <div class="container">
        <div class="row">
            <!-- SHOPPING-CART START -->
            <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 pull-right shopingcartarea">
                <div class="shopping-cart-out pull-right">
                    <div class="shopping-cart">
                        <a class="shop-link" href="<c:url value='/cart'/>" title="Xem giở hàng">
                            <i class="fa fa-shopping-cart cart-icon"></i>
                            <b>Giỏ hàng</b>
                            <span class="ajax-cart-quantity">
                            	<c:if test="${cart.size() >0 }">${ cart.size() }</c:if>
                            </span>
                        </a>
                        <c:if test="${cart.size()>0 }">
	                        <div class="shipping-cart-overly">
	                        	<c:forEach var="item" items="${cart }" end="2">
	                        		<c:set value="${item.value }" var="value"/>
	                        		<div class="shipping-item">
		                                <div class="shipping-item-image">
		                                    <a href="<c:url value='/product/info/${ value.prod.productId}'/>">
		                                    	<img src="<c:url value='/assets/user/img/product/${value.prod.productImage }'/>" alt="image" width="80" />
		                                    </a>
		                                </div>
		                                <div class="shipping-item-text">
		                               	 	<a href="<c:url value='/product/info/${ value.prod.productId}'/>" class="pro-cat product-name-text">${value.prod.productName }</a>
		                                    <span>
		                                   		${value.quantity } x <fmt:formatNumber type="currency" maxFractionDigits="0" currencySymbol="₫" value="${value.prod.productPrice - value.prod.productDiscount }"/>
		                                    </span>
		                                </div>
	                        	    </div>
	                        	</c:forEach>
	                            <div class="shipping-total-bill">
	                                <div class="total-shipping-prices">
	                                    <span class="shipping-total"><fmt:formatNumber type="currency" maxFractionDigits="0" currencySymbol="₫" value="${totalPriceCart }"/></span>
	                                    <span>Tổng</span>
	                                </div>
	                            </div>
	                            <div class="shipping-checkout-btn">
	                                <a href="<c:url value='/cart'/>">Xem tất cả <i class="fa fa-chevron-right"></i></a>
	                            </div>
	                        </div>
                        </c:if>
                    </div>
                </div>
            </div>
            <!-- SHOPPING-CART END -->
           
        </div>
        
    </div>
</header>
<!-- MAIN-MENU-AREA END -->