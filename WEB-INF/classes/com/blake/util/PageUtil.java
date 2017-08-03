package com.blake.util;

/**
 * @see 包分页辅助类
 * @author Blake.Zhou
 *
 */
public class PageUtil {
	/**
	 * @see 创建分页信息对象
	 * @param everyPage
	 * @param totalCount
	 * @param currentPage
	 * @return
	 */
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}

	/**
	 * @see 获得每页显示记录数
	 * @param everyPage
	 * @return
	 */
	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	/**
	 * @see 获得当前页
	 * @param currentPage
	 * @return
	 */
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * @see 获得总页数
	 * @param everyPage
	 * @param totalCount
	 * @return
	 */
	public static int getTotalPage(int everyPage, int totalCount) {
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	/**
	 * @see 获得起始位置
	 * @param everyPage
	 * @param currentPage
	 * @return
	 */
	public static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	/**
	 * @see 获得是否有上一页
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	/**
	 * @see 获得是否有上一页
	 * @param totalPage
	 * @param currentPage
	 * @return
	 */
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
}
