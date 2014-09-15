

public class Helper {
	
	public static boolean check(Point p1, Point p2){
		if(p1.x==p2.x || p1.y==p2.y || Math.abs(p1.y-p2.y)==Math.abs(p1.x-p2.x))
			return false;
	return true;
	}
/*
	public static boolean check(Point p1, final Tree<Point> tree) {
		Tree<Point> tmp = tree;
		boolean flag = true;
		Point p2;
		while(tmp.root.parent != null){
			p2 = tmp.root.data;
			if(Helper.check(p1, p2)){
				flag = false;
			}
			tree.roo
		}
		return flag;
	}*/
	/*
	public static boolean check(Point p1, Node<Point> root) {
		boolean flag=true;
		if(root.parent != null){
			flag = check(p1,root.parent.data);
			flag &= check(p1, root.parent);
		}
		return flag;
	}*/
}


