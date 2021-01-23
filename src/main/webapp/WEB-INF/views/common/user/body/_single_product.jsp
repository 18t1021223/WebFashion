<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title>${product.productName}</title>
     <!-- MAIN-CONTENT-SECTION START -->
    <section class="main-content-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <!-- BSTORE-BREADCRUMB START -->
                    <div class="bstore-breadcrumb">
                        <a href="<c:url value='/home'/>">Trang chủ </a>
                        <c:forEach var="item" items="${link}">
                            <span> <i class="fa fa-caret-right"> </i> </span>
                            <span style="cursor: pointer;" class='Subcategory' data-categoryid='${ item.categoryId }'>${item.categoryName }</span>
                        </c:forEach>
                        <span> <i class="fa fa-caret-right"> </i> </span>
                        <span>${product.productName}</span>
                    </div>
                    <!-- BSTORE-BREADCRUMB END -->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <!-- SINGLE-PRODUCT-DESCRIPTION START -->
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-4 col-xs-12">
                            <div class="single-product-view">
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="thumbnail_1">
                                        <div class="single-product-image">
                                            <img src="<c:url value='/assets/user/img/product/sale/${product.productImage}'/>" alt="single-product-image" />
                                            <a class="fancybox" href="<c:url value='/assets/user/img/product/sale/${product.productImage}'/>" data-fancybox-group="gallery"><span class="btn large-btn">Xem hình<i class="fa fa-search-plus"></i></span></a>
                                        </div>
                                    </div>
                                    <c:forEach var="item" items="${product.images}" varStatus="index">
                                        <div class="tab-pane" id="thumbnail_${index.index+2}">
                                            <div class="single-product-image">
                                                <img src="<c:url value='/assets/user/img/product/sale/${item.imageUrl}'/>" alt="single-product-image" />
                                                <a class="fancybox" href="<c:url value='/assets/user/img/product/sale/${item.imageUrl}'/>" data-fancybox-group="gallery"><span class="btn large-btn">Xem hình<i class="fa fa-search-plus"></i></span></a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <c:if test="${product.images.size()>0}">
                                <div class="select-product">
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs select-product-tab bxslider">
                                        <li class="active">
                                            <a href="#thumbnail_1" data-toggle="tab"><img src="<c:url value='/assets/user/img/product/sidebar_product/${product.productImage}'/> " alt="pro-thumbnail" /></a>
                                        </li>
                                        <c:forEach var="item" items="${product.images}" varStatus="index">
                                            <li>
                                                <a href="#thumbnail_${index.index+2}" data-toggle="tab"><img src="<c:url value='/assets/user/img/product/sidebar_product/${item.imageUrl}'/>" alt="pro-thumbnail" /></a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-8 col-xs-12">
                            <form action="#" method="post" id="form-order">
                                <div class="single-product-descirption">
                                    <h2>${product.productName}</h2>
                                    <div class="single-product-price">
                                        <h2><fmt:formatNumber type="currency" maxFractionDigits="0" currencySymbol="₫" value="${product.productPrice - product.productDiscount}"/></h2>
                                        <c:if test="${product.productDiscount > 0}">
                                            <h3 style="text-decoration: line-through;"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${product.productPrice}"/> </h3>
                                        </c:if>
                                    </div>
                                    <div class="single-product-desc">
                                        <p>${product.productTitle}</p>
                                    </div>
                                    <div class="single-product-option">
                                        <p class="small-title">Số lượng</p>
                                        <div>
                                            <input class="see-more-btn single-product-qty" type="number" name="quantity" value="1" max="20" min="1" >
                                        </div>
                                    </div>
                                    <c:if test="${product.sizes.size()>0}">
                                        <div class="single-product-option">
                                            <p class="small-title">Size</p>
                                            <div class="radio-convert">
                                                <c:forEach var="item" items="${product.sizes}" varStatus="index">
                                                    <input type="radio" id="size_${index.index+1}" name="sizeId" value="${item.sizeId}" required>
                                                    <label for="size_${index.index+1}">${item.sizeName} </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
                                    <c:if test="${product.colors.size()>0}">
                                        <div class="single-product-option">
                                            <p class="small-title">Màu</p>
                                            <div class="radio-convert">
                                                <c:forEach var="item" items="${product.colors}" varStatus="index">
                                                    <input type="radio" id="color_${index.index+1}" name="colorId" value="${item.colorId}" required>
                                                    <label for="color_${index.index+1}">${item.colorName}</label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:if>
                                    <div class="single-product-add-cart">
                                        <input type="hidden" value="${product.productId }" name="productId">
                                        <button class="add-cart-text add-cart-submit" title="Thêm vào giỏ" >Thêm vào giỏ</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- SINGLE-PRODUCT-DESCRIPTION END -->
                    <!-- SINGLE-PRODUCT INFO TAB START -->
                    <div class="row">
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                            <div class="product-more-info-tab">
                                <!-- Nav tabs -->
                                <ul class="nav nav-tabs more-info-tab">
                                    <li class="active"><a href="#moreinfo" data-toggle="tab">Mô tả sản phẩm</a></li>
                                <%--    <li><a href="#datasheet" data-toggle="tab">Chi tiết sản phẩm</a></li>  --%>
                                </ul>
                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div class="tab-pane active" id="moreinfo">
                                        <div class="tab-description">
                                            <p>${product.description}</p>
                                        </div>
                                    </div>
                             <%--       <div class="tab-pane" id="datasheet">
                                        <div class="deta-sheet">
                                            <table class="table-data-sheet">
                                                <tbody>
                                                    <tr class="odd">
                                                        <td>Compositions</td>
                                                        <td>Cotton</td>
                                                    </tr>
                                                    <tr class="even">
                                                        <td class="td-bg">Styles</td>
                                                        <td class="td-bg">Casual</td>
                                                    </tr>
                                                    <tr class="odd">
                                                        <td>Properties</td>
                                                        <td>Short Sleeve</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div> --%>
                                </div>
                            </div>
                        </div>
<%--                        <!-- RIGHT SIDE BAR START -->--%>
<%--                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">--%>
<%--                            <!-- SINGLE SIDE BAR START -->--%>
<%--                            <div class="single-product-right-sidebar">--%>
<%--                                <a href="" class="left-title">Sản phẩm đã xem</a>--%>
<%--                                <ul>--%>
<%--                                    <li>--%>
<%--                                        <a href="#"><img src="img/product/sidebar_product/2.jpg" alt="" /></a>--%>
<%--                                        <div class="r-sidebar-pro-content">--%>
<%--                                            <h5><a href="#">Faded Short ...</a></h5>--%>
<%--                                            <p>Faded short sleeves t-shirt with high...</p>--%>
<%--                                        </div>--%>
<%--                                    </li>--%>
<%--                                    <li>--%>
<%--                                        <a href="#"><img src="img/product/sidebar_product/4.jpg" alt="" /></a>--%>
<%--                                        <div class="r-sidebar-pro-content">--%>
<%--                                            <h5><a href="#">Printed Chif ..</a></h5>--%>
<%--                                            <p>Printed chiffon knee length dress...</p>--%>
<%--                                        </div>--%>
<%--                                    </li>--%>
<%--                                    <li>--%>
<%--                                        <a href="#"><img src="img/product/sidebar_product/6.jpg" alt="" /></a>--%>
<%--                                        <div class="r-sidebar-pro-content">--%>
<%--                                            <h5><a href="#">Printed Sum ...</a></h5>--%>
<%--                                            <p>Long printed dress with thin...</p>--%>
<%--                                        </div>--%>
<%--                                    </li>--%>
<%--                                    <li>--%>
<%--                                        <a href="#"><img src="img/product/sidebar_product/1.jpg" alt="" /></a>--%>
<%--                                        <div class="r-sidebar-pro-content">--%>
<%--                                            <h5><a href="#">Printed Dress </a></h5>--%>
<%--                                            <p>100% cotton double printed dress....</p>--%>
<%--                                        </div>--%>
<%--                                    </li>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                            <!-- SINGLE SIDE BAR END -->--%>
<%--                        </div>--%>

                    </div>
                    <!-- SINGLE-PRODUCT INFO TAB END -->
                    <!-- RELATED-PRODUCTS-AREA START -->
                    <c:if test="${productRelated.size() >0 }">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="left-title-area">
                                    <h2 class="left-title">Sản phẩm Tương tự</h2>
                                </div>
                            </div>
                            <div class="related-product-area featured-products-area">
                                <div class="col-sm-12">
                                    <div class=" row">
                                        <!-- RELATED-CAROUSEL START -->
                                        <div class="related-product">
                                            <c:forEach var="item" items="${productRelated}">
                                                <!-- SINGLE-PRODUCT-ITEM START -->
                                                <div class="item">
                                                    <div class="single-product-item">
                                                        <div class="product-image">
                                                            <a href="<c:url value='/product/info/${item.productId}'/>">
                                                                <img src="<c:url value='/assets/user/img/product/sale/${item.productImage}'/>" alt="product-image" />
                                                            </a>
                                                            <c:if test="${item.productDiscount >0 }">
                                                                <a href="<c:url value='/product/info/${item.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number" maxFractionDigits="0"  value="${item.productDiscount/item.productPrice *100 }"/>%</a>
                                                            </c:if>
                                                        </div>
                                                        <div class="product-info">
                                                            <a href="<c:url value='/product/info/${item.productId}'/>" class="product-name-text">${item.productName}</a>
                                                            <div class="price-box">
                                                                <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice-item.productDiscount}"/></span>
                                                                <c:if test="${item.productDiscount >0}">
                                                                    <span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice}"/></span>
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- SINGLE-PRODUCT-ITEM END -->
                                            </c:forEach>
                                        </div>
                                        <!-- RELATED-CAROUSEL END -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- RELATED-PRODUCTS-AREA END -->
                    </c:if>
                </div>

            </div>
        </div>
    </section>
    <!-- MAIN-CONTENT-SECTION END -->