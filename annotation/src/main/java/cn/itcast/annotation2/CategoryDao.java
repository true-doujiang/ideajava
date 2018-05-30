package cn.itcast.annotation2;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CategoryDao {
	
	private ComboPooledDataSource combods;

	@Inject
	public void setCombods(ComboPooledDataSource combods) {
		this.combods = combods;
	}
	
}
