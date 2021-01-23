<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<title> Danh sách sản phẩm</title>
<!-- MAIN-CONTENT-SECTION START -->
    <section class="main-content-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <!-- BSTORE-BREADCRUMB START -->
                    <div class="bstore-breadcrumb">
                        <a href="<c:url value='/home'/>">Trang chủ</a>
                        <c:forEach var="item" items="${parentCategory }" varStatus="index">
                        	<c:if test="${index.last }">
                        		<c:set var="parent" value="${item}"/>
                        	</c:if>
                        	<span><i class="fa fa-caret-right"></i></span>
                        	<span style="cursor: pointer;" class='Subcategory' data-categoryid='${ item.categoryId }'>${item.categoryName }</span>
                        </c:forEach>
                    </div>
                    <!-- BSTORE-BREADCRUMB END -->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                    <!-- PRODUCT-LEFT-SIDEBAR START -->
                    <div class="product-left-sidebar">
                        <span class="sidebar-title">Danh mục</span>
                        <!-- SINGLE SIDEBAR CATEGORIES START -->
                        <div class="product-single-sidebar">
                            <ul class='product-single-sidebar-ul'>
                            	<c:forEach var="item" items="${categorySelect }">
                            		<li class='category-li'><i class="fa fa-angle-right"></i>
                            			<a <c:if test="${item.categoryId ==  parent.categoryId }"><c:out value="class=category-select"/></c:if> href="#" data-categoryid='${item.categoryId }'> ${item.categoryName }</a>
                            		</li>
                            	</c:forEach>
                            </ul>
                        </div>
                        <!-- SINGLE SIDEBAR CATEGORIES END -->
                    </div>
                    <!-- PRODUCT-LEFT-SIDEBAR END -->
                </div>
                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                    <div class="right-all-product">
                        <div class="product-category-title">
                            <!-- PRODUCT-CATEGORY-TITLE START -->
                            <h1>
								<c:if test="${ parent ==null}">
									<span class="cat-name" id='parent' data-categoryid='0'>Tất cả sản phẩm</span>
								</c:if>
								<c:if test="${ parent !=null}">
									<span class="cat-name" id='parent' data-categoryid='${ parent.categoryId}'>${parent.categoryName }</span>
								</c:if>
                                <span class="count-product">Có ${totalProduct } sản phẩm.</span>
                            </h1>
                            <!-- PRODUCT-CATEGORY-TITLE END -->
                        </div>
                        <div class="product-shooting-area">
                            <div class="product-shooting-bar">
                                <!-- SHOORT-BY START -->
                                <div class="shoort-by">
                                    <label for="sortBy">Sắp xếp</label>
                                    <span class="after-icon-down"></span>
                                    <select class="sortby-form" name="" id="sortBy">
											<option value="1" <c:if test="${paginate.orderBy==1 }"> <c:out value="selected"/></c:if>>Giá: thấp đến cao</option>
											<option value="2" <c:if test="${paginate.orderBy==2 }"> <c:out value="selected"/></c:if>>Giá: cao đến thấp</option>
											<option value="3" <c:if test="${paginate.orderBy==3 }"> <c:out value="selected"/></c:if>>Sản phẩm nổi bật</option>
											<option value="4" <c:if test="${paginate.orderBy==4 }"> <c:out value="selected"/></c:if>>Sản phẩm mới</option>
											<option value="5" <c:if test="${paginate.orderBy==5 }"> <c:out value="selected"/></c:if>>Sản phẩm giảm giá</option>
									</select>
                                </div>
                                <!-- SHOORT-BY END -->
                            </div>
                        </div>
                    </div>
                    <!-- ALL GATEGORY-PRODUCT START -->
                    <div class="all-gategory-product">
                        <div class="row">
                            <ul class="gategory-product">
                             <c:if test="${product_select_by_category.size()>0 }">
                             	<c:forEach var="item" items="${product_select_by_category }">
                             		<!-- SINGLE ITEM START -->
	                                <li class="gategory-product-list col-lg-3 col-md-4 col-sm-6 col-xs-12">
	                                    <div class="single-product-item">
	                                        <div class="product-image">
	                                            <a href="<c:url value='/product/info/${item.productId}'/>"><img src="<c:url value='/assets/user/img/product/sale/${item.productImage }'/>" alt="product-image" /></a>
	                                            <c:if test="${item.productDiscount >0 }">
	                                            	<a href="<c:url value='/product/info/${item.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number"  maxFractionDigits="0"  value="${  item.productDiscount/item.productPrice *100}"/>%</a>
	                                            </c:if>
	                                            <div class="overlay-content">
	                                                <ul>
	                                                    <li><a href="<c:url value='/product/info/${item.productId}'/>" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li>
	                                                    
	                                                </ul>
	                                            </div>
	                                        </div>
	                                        <div class="product-info">
                                                <a href="<c:url value='/product/info/${item.productId}'/>" class="product-name-text">${item.productName }</a>
                                                <div class="price-box">
                                                    <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice -item.productDiscount }"/></span>
                                                    <c:if test="${item.productDiscount >0 }">
                                                    	<span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice}"/></span>
                                                    </c:if>
                                                </div>
			                               </div>
	                                    </div>
	                                </li>
	                                <!-- SINGLE ITEM END -->
                             	</c:forEach>
                             </c:if>
                            </ul>
                        </div>
                    </div>
                    <!-- ALL GATEGORY-PRODUCT END -->
                    <c:if test="${paginate.totalPage >0 }">
	                    <!-- PRODUCT-SHOOTING-RESULT START -->
	                    <div class="product-shooting-result product-shooting-result-border">
	                        <div class="showing-item">
	                            <span>Trang ${paginate.page } / ${paginate.totalPage }</span>
	                        </div>
	                        <div class="showing-next-prev">

	                            <ul class="pagination-bar">
	                                <li <c:if test="${paginate.page ==1 }">
	                                		<c:out value="class=disabled"/>
	                                	</c:if>
										>
	                                    <a  class='direction' href="" data-page="${paginate.page-1 }"><i class="fa fa-chevron-left"></i></a>
	                                </li>
	                                <c:forEach var="item" begin="${paginate.start }" end="${paginate.end }">
	                                	<c:if test="${paginate.page == item }">
	                                		<li class="active disabled" data-page="${paginate.page }">
	                                			<span><a class="pagi-num" href="" data-page="${item }"> ${item }</a></span>
	                                		</li>
	                                	</c:if>
	                                	<c:if test="${paginate.page != item }">
	                                		<li data-page="${paginate.page }">
	                                			<span><a class="pagi-num" href="" data-page="${item }"> ${item }</a></span>
	                                		</li>
	                                	</c:if>
	                                </c:forEach>
	                                <li <c:if test="${  paginate.page == paginate.end }">
	                                		<c:out value="class=disabled"/>
	                                	</c:if>
									>
	                                    <a class='direction' href="" data-page="${paginate.page+1 }"><i class="fa fa-chevron-right"></i></a>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                    <!-- PRODUCT-SHOOTING-RESULT END -->
                    </c:if>
                </div>
            </div>
        </div>
    </section>
    <!-- MAIN-CONTENT-SECTION END -->