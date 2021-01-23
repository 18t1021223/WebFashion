<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
<!-- LEFT-CATEGORY-MENU START -->
				<div class="left-category-menu">
					<div class="left-product-cat">
						<div class="category-heading">
							<h2>Danh mục</h2>
						</div>
						<!-- CATEGORY-MENU-LIST START -->
						<div class="category-menu-list">
							<ul>
								<c:if test="${categorySearch.size()>0 }">	
									<c:forEach var="item" items="${categorySearch }" varStatus="index">
										<c:if test="${item.level ==0 }">
											<li>
											<a href="shop-gird.html"> 
												<span class="cat-thumb hidden-md hidden-sm hidden-xs"></span>
												${item.categoryName }
												<i class="fa fa-angle-right"></i>
											</a>
											<c:if test="${item.level == 0 }">
												<div class="cat-left-drop-menu">
													<c:forEach var="item1" items="${categorySearch }" begin="${index.index+1 }" varStatus="index1">
														<c:choose>
															<c:when test="${ item1.level == 1 && item1.parentId == item.categoryId}">
																<div class="cat-left-drop-menu-left">
																	<a class="menu-item-heading" href="shop-gird.html">${item1.categoryName }</a>
																	<ul>
																		<c:forEach var="item2" items="${categorySearch }" begin="${index1.index+1 }" varStatus="index2">
																			
																			<c:if test="${item2.level>1 && item2.parentId == item1.categoryId}">
																				<li><a href="shop-gird.html">${item2.categoryName }</a></li>
																			</c:if>
																		</c:forEach>
																	</ul>
																</div>
															</c:when>	
														</c:choose>
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