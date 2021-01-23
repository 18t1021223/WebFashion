package com.web.dto;

public class mapKey {
	private long productId;
	private long sizeId;
	private long colorId;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSizeId() {
		return sizeId;
	}

	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public mapKey(long productId, long sizeId, long colorId) {
		super();
		this.productId = productId;
		this.sizeId = sizeId;
		this.colorId = colorId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (colorId ^ (colorId >>> 32));
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + (int) (sizeId ^ (sizeId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof mapKey) {
			mapKey key = (mapKey) obj;
			if (key.getProductId() == this.productId && key.getColorId() == this.colorId
					&& key.getSizeId() == this.sizeId)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return productId + "-" + sizeId + "-" + colorId;
	}

}
