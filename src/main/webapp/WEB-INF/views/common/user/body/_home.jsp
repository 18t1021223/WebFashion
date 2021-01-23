<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<title> Trang chủ</title>
  <!-- HEADER-BOTTOM-AREA START -->
   <section class="header-bottom-area">
       <div class="container">
           <div class="row">
               <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
               	<!-- LEFT-CATEGORY-MENU START -->
			<div class="left-category-menu">
				<div class="left-product-cat">
					<div class="category-heading">
						<h2>Danh mục</h2>
					</div>
					<!-- CATEGORY-MENU-LIST START -->
					<div class="category-menu-list">
						<ul>
							<c:set var="categorySearchSize" value="${categorySearch.size() }"/>
							<c:if test="${categorySearchSize >0 }">
								<c:forEach var="item" items="${categorySearch }" varStatus="index" end="${categorySearchSize-1}">
									<c:if test="${item.level ==0 }">
										<li>
										<a href="<c:url value='/product/category?categoryId=${item.categoryId }'/>">
											<span class="cat-thumb hidden-md hidden-sm hidden-xs"></span>
											${item.categoryName }
											<i class="fa fa-angle-right"></i>
										</a>

										<c:if test="${item.level == 0 && index.index != categorySearchSize -1 && categorySearch.get(index.index+1).level >0}">
											<div class="cat-left-drop-menu">
												<c:forEach var="item1" items="${categorySearch }" begin="${index.index+1 }" varStatus="index1">
														<c:if test="${ item1.level == 1 && item1.parentId == item.categoryId}">
															<div class="cat-left-drop-menu-left">
																<a class="menu-item-heading" href="<c:url value='/product/category?categoryId=${item1.categoryId }'/>">${item1.categoryName }</a>
																<ul>
																	<c:forEach var="item2" items="${categorySearch }" begin="${index1.index+1 }" varStatus="index2">
																		
																		<c:if test="${item2.level>1 && item2.parentId == item1.categoryId}">
																			<li><a href="<c:url value='/product/category?categoryId=${item2.categoryId }'/>">${item2.categoryName }</a></li>
																		</c:if>
																	</c:forEach>
																</ul>
															</div>
														</c:if>	
												</c:forEach>
											</div>
										</c:if>											
										</li>	
									</c:if>
								</c:forEach>
							</c:if>
						</ul>
					</div>
					<!-- CATEGORY-MENU-LIST END -->
				</div>
			</div>
			<!-- LEFT-CATEGORY-MENU END -->
                   
               </div>
               <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                   <!-- MAIN-SLIDER-AREA START -->
                   <div class="main-slider-area">
                       <div class="slider-area">
                           <div id="wrapper">
                               <div class="slider-wrapper">
                              		 <div id="mainSlider" class="nivoSlider">
                              			 <c:forEach var="item" items="${slideAll }" varStatus="index">
                                        <img src="<c:url value='/assets/user/img/slider/homepage2/${item.slideImage }'/>" alt="main slider" title="#htmlcaption${index.index+1 }" />
                               	   	</c:forEach>
                               	</div>
                               	<c:forEach var="item" items="${slideAll }" varStatus="index">
                               		<div id="htmlcaption${index.index+1 }" class="nivo-html-caption slider-caption">
                                        <div class="slider-cap-text">
                                            <div class="d-table-cell">
                                                <h2 class="animated bounceInDown">${item.slideCaption }</h2>
                                                <p class="animated bounceInUp">${item.slideContext }</p>
                                                <c:if test="${item.slideLink != null }">
                                               		<a class="wow zoomInDown" data-wow-duration="1s" data-wow-delay="1s" href="<c:url value='${item.productLink }'/>">Xem thêm<i class="fa fa-caret-right"></i></a>
                                            	</c:if>
                                            </div>
                                        </div>
                                 	   </div>
                               	</c:forEach>
                               </div>
                           </div>
                       </div>
                   </div>
                   <!-- MAIN-SLIDER-AREA END -->
               </div>
           </div>
       </div>
   </section>
   <!-- HEADER-BOTTOM-AREA END -->
   <!-- MAIN-CONTENT-SECTION START -->
   <section class="main-content-section">
       <div class="container">
           <div class="row">

               <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                   <div class="row">
                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                           <div class="new-product-area">
                               <div class="left-title-area">
                                   <h2 class="left-title">Sản phẩm mới</h2>
                               </div>
                               <div class="row">
                                   <div class="col-xs-12">
                                       <div class="row">
                                           <div class="home2-new-pro-carousel">
                                               <!-- NEW-PRODUCT SINGLE ITEM START -->
                                               <c:forEach var="item" items="${products_select_new }">
                                            	   <!-- HOME2-NEW-PRO-CAROUSEL START -->
                                                	<div class="item">
                                                    <div class="new-product">
                                                        <div class="single-product-item">
                                                            <div class="product-image">
                                                                <a href="<c:url value='/product/info/${item.productId}'/>"><img src="<c:url value='/assets/user/img/product/sale/${item.productImage }'/>" alt="product-image" /></a>
                                                                <c:if test="${item.productDiscount >0 }">
                                                                	<a href="<c:url value='/product/info/${item.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number" maxFractionDigits="0"  value="${item.productDiscount/item.productPrice *100}"/>%</a>
                                                                </c:if>
                                                                <div class="overlay-content">
                                                                    <ul>
                                                                        <li><a href="<c:url value='/product/info/${item.productId}'/>" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li>
                                                                      
                                                                    </ul>
                                                                </div>
                                                            </div>
		                                                    <div class="product-info">
		                                                        <a href="single-product.html" class="product-name-text">${item.productName }</a>
		                                                        <div class="price-box">
		                                                            <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice -item.productDiscount }"/></span>
		                                                            <c:if test="${item.productDiscount >0 }">
		                                                            	<span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice}"/></span>
		                                                            </c:if>
		                                                        </div>
		                                                    </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- NEW-PRODUCT SINGLE ITEM END -->
                                               </c:forEach>                                            
                                           </div>
                                           <!-- HOME2-NEW-PRO-CAROUSEL END -->
                                       </div>
                                   </div>
                               </div>
                               <div class="see-more">
                                   <a href="<c:url value="/product/category?categoryId=0&orderBy=4"/>" class="see-more-btn add-cart-text">Xem thêm</a>
                               </div>
                           </div>
                       </div>

                       <div class="col-xs-12">
                           <!-- SALE-PODUCT-AREA START -->
                           <div class="sale-poduct-area new-product-area">
                               <div class="left-title-area">
                                   <h2 class="left-title">Sản phẩm khuyễn mãi</h2>
                               </div>
                               <div class="row">
                                   <!-- HOME2-SALE-CAROUSEL START -->
                                   <div class="home2-sale-carousel">
                                   	<c:forEach var="item" items="${products_select_discount }">
                                   	 <!-- NEW-PRODUCT SINGLE ITEM START -->
                                        <div class="item">
                                            <div class="new-product">
                                                <div class="single-product-item">
                                                    <div class="product-image">
                                                        <a href="<c:url value='/product/info/${item.productId}'/>"><img src="<c:url value='/assets/user/img/product/sale/${item.productImage }'/>" alt="product-image" /></a>
                                                        <c:if test="${item.productDiscount >0 }">
                                                        	<a href="<c:url value='/product/info/${item.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number" maxFractionDigits="0" value="${100-((item.productPrice-item.productDiscount)/item.productPrice*100) }"/>%</a>
                                                        </c:if>
                                                        <div class="overlay-content">
                                                            <ul>
                                                                <li><a href="<c:url value='/product/info/${item.productId}'/>" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li>
                                                                <li><a href="#" title="Thêm vào giở"><i class="fa fa-shopping-cart"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="product-info">
                                                        <a href="single-product.html" class="product-name-text">${item.productName }</a>
                                                        <div class="price-box">
                                                            <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice -item.productDiscount }"/></span>
                                                            <c:if test="${item.productDiscount >0 }">
                                                            	<span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice}"/></span>
                                                            </c:if>
                                                        </div>
		                                            </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- NEW-PRODUCT SINGLE ITEM END -->
                                   	</c:forEach>
                                   </div>
                                   <!-- HOME2-SALE-CAROUSEL END -->
                               </div>
                               <div class="see-more">
                                   <a href="<c:url value="/product/category?categoryId=0&orderBy=5"/>" class="add-cart-text see-more-btn">Xem thêm</a>
                               </div>
                           </div>
                           <!-- SALE-PODUCT-AREA end -->
                       </div>
                   </div>
               </div>
           </div>
       </div>
   </section>
   <!-- MAIN-CONTENT-SECTION END -->
   <!-- MAIN-CONTENT-SECTION START -->
   <section class="main-content-section-full-column">
       <div class="container">
           <div class="row">
               <div class="col-xs-12">
                   <!-- FEATURED-PRODUCTS-AREA START -->
                   <div class="featured-products-area">
                       <div class="left-title-area">
                           <h2 class="left-title">Sản phẩm nổi bật</h2>
                       </div>
                       <div class="row">
                           <!-- FEARTURED-CAROUSEL START -->
                           <div class="feartured-carousel">
                               <c:forEach var="item" items="${products_select_highlight }" step="2" begin="0" varStatus="index">
                               	<!-- SINGLE ITEM START -->
                                <div class="item">
                                    <!-- SINGLE-PRODUCT-ITEM START -->
                                    <div class="single-product-item">
                                        <div class="product-image">
                                            <a href="<c:url value='/product/info/${item.productId}'/>"><img src="<c:url value='/assets/user/img/product/sale/${item.productImage }'/>" alt="product-image" /></a>
                                            <c:if test="${item.productDiscount > 0 }">
                                            	<a href="<c:url value='/product/info/${item.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number" maxFractionDigits="0" value="${100-((item.productPrice-item.productDiscount)/item.productPrice*100) }"/>%</a>
                                            </c:if>
                                            <div class="overlay-content">
                                                <ul>
													<li><a href="<c:url value='/product/info/${item.productId}'/>" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li>
                                                    <li><a href="#" title="Thêm vào giở"><i class="fa fa-shopping-cart"></i></a></li>
                                      			     </ul>
                                            </div>
                                        </div>
                                        <div class="product-info">
                                               <a href="single-product.html" class="product-name-text">${item.productName }</a>
                                               <div class="price-box">
                                                   <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice -item.productDiscount }"/></span>
                                                   <c:if test="${item.productDiscount >0 }">
                                                   	<span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item.productPrice}"/></span>
                                                   </c:if>
                                               </div>
		                               </div>
                                    </div>
                                    <!-- SINGLE-PRODUCT-ITEM END -->
                                    <c:forEach var="item2" items="${products_select_highlight }" begin="${index.index+1 }" end="${index.index+1 }">
                                    	<!-- SINGLE-PRODUCT-ITEM START -->
	                                    <div class="single-product-item">
	                                        <div class="product-image">
	                                            <a href="<c:url value='/product/info/${item2.productId}'/>"><img src="<c:url value='/assets/user/img/product/sale/${item2.productImage }'/>" alt="product-image" /></a>
	                                            <c:if test="${item2.productDiscount > 0 }">
	                                            	<a href="<c:url value='/product/info/${item2.productId}'/>" class="new-mark-box">-<fmt:formatNumber type="number" maxFractionDigits="0" value="${100-((item2.productPrice-item2.productDiscount)/item2.productPrice*100) }"/>%</a>
	                                            </c:if>
	                                            <div class="overlay-content">
	                                                <ul>
	                                                    <li><a href="<c:url value='/product/info/${item2.productId}'/>" title="Xem sản phẩm"><i class="fa fa-search"></i></a></li>
	                                                    <li><a href="#" title="Thêm vào giở"><i class="fa fa-shopping-cart"></i></a></li>
                                       			     </ul>
	                                            </div>
	                                        </div>
	                                        <div class="product-info">
                                                <a href="single-product.html" class="product-name-text">${item2.productName }</a>
                                                <div class="price-box">
                                                    <span class="price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item2.productPrice -item2.productDiscount }"/></span>
                                                    <c:if test="${item2.productDiscount >0 }">
                                                    	<span class="old-price"><fmt:formatNumber type="currency" currencySymbol="₫" maxFractionDigits="0" value="${item2.productPrice}"/></span>
                                                    </c:if>
                                                </div>
			                               </div>
	                                    </div>
	                                    <!-- SINGLE-PRODUCT-ITEM END -->       	       	
                                    </c:forEach>
                                </div>
                                <!-- SINGLE ITEM END -->
                               </c:forEach>
                           </div>
                           <!-- FEARTURED-CAROUSEL END -->
                       </div>
                       <div class="see-more">
                           <a href="<c:url value="/product/category?categoryId=0&orderBy=3"/>" class="add-cart-text see-more-btn">Xem thêm</a>
                       </div>
                   </div>
                   <!-- FEATURED-PRODUCTS-AREA END -->
               </div>
           </div>
       </div>
   </section>
   <!-- MAIN-CONTENT-SECTION END -->