import java.awt.Color;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Algorithm {
	List<ArrayList<Double>> list1 = null;
	List<ArrayList<Double>> list2 = null;
	List<Line> tmp;

	public Algorithm() throws FileNotFoundException, IOException {
		this.list1 = Helper.parseFile(Properties.file1);
		this.list2 = Helper.parseFile(Properties.file2);

	}

	public List<Line> findCouples() {
		tmp = new ArrayList<Line>();
		Integer val = null;
		for (int i = 0; i < this.list1.size(); i++) {
			val = Helper.checkCouples(i, this.list1, this.list2);
			if (val != null) {
				/*
				float hue = (float) Math.random();
				int rgb = Color.HSBtoRGB(hue, 0.5f, 0.5f);
				*
				 * tmp.add(new Line(
				 * this.list1.get(i).get(0).intValue(),this.list1
				 * .get(i).get(1).intValue(),
				 * this.list2.get(val).get(0).intValue(),
				 * this.list2.get(val).get(1).intValue(), new Color(rgb)));
				 */
				tmp.add(new Line(i, val, 0, 0, null));
			}
		}
		System.out.println("Searching done, [" + tmp.size() + " couples]");
		return tmp;
	}

	public List<Line> analizaSpojnosci() {
		System.out.println("przedostania prosta");
		List<Line> _out = new ArrayList<Line>();
		List<Line> tmp2improve = new ArrayList<Line>();
		double tmpVal;
		for (int i = 0; i < this.tmp.size(); i++) {
			List<Punkt> p1List = helpMethod1(i, list1);
			List<Punkt> p2List = helpMethod2(i, list2);
			System.out.println("ostatnia duza petla " +i);
			for (int k1 = 0; k1 < Properties.n; k1++) {
				int flag = -1;
				int iter=0;
				for (int k2 = 0; k2 < Properties.n; k2++) {
					if (p1List.get(k1).i == p2List.get(k2).i) {
						flag = p1List.get(k1).i;
						iter++;
					}
				}
				if (flag != -1 ) {
					tmp2improve.add(this.tmp.get(flag));
				}
			}

		}
		System.out.println("ostania prosta");
		List<Line> tmp2output = new ArrayList<Line>();
		
		
		
		for(int i=0;i<tmp2improve.size();i++){
			float hue = (float) Math.random();
			int rgb = Color.HSBtoRGB(hue, 0.5f, 0.5f);
			
			tmp2output.add(new Line(
					 this.list1.get(tmp2improve.get(i).x1).get(0).intValue(),this.list1
				 .get(tmp2improve.get(i).x1).get(1).intValue(),
				 this.list2.get(tmp2improve.get(i).y1).get(0).intValue(),
				 this.list2.get(tmp2improve.get(i).y1).get(1).intValue(), new Color(rgb)));
		}
		
		
		System.out.println("skonczone");
		return tmp2output;
	}

	private List<Punkt> helpMethod1(int i, List<ArrayList<Double>> _tmp) {
		List<Punkt> p1List = new ArrayList<Punkt>();
		for (int j = 0; j < this.tmp.size(); j++) {
			if (i != j) {
				p1List.add(new Punkt(j, Helper.liczOdleglosc(
						_tmp.get(this.tmp.get(i).x1),
						_tmp.get(this.tmp.get(j).x1))));
			}
		}
		Collections.sort(p1List);
		return p1List;
	}

	private List<Punkt> helpMethod2(int i, List<ArrayList<Double>> _tmp) {
		List<Punkt> p1List = new ArrayList<Punkt>();
		for (int j = 0; j < this.tmp.size(); j++) {
			if (i != j) {
				p1List.add(new Punkt(j, Helper.liczOdleglosc(
						_tmp.get(this.tmp.get(i).y1),
						_tmp.get(this.tmp.get(j).y1))));
			}
		}
		Collections.sort(p1List);
		return p1List;
	}

}
