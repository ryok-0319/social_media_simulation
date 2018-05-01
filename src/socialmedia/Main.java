package socialmedia;

import java.util.Arrays;

public class Main {

	/**
	 * @param args
	 */
	// エージェントの数
	public static final int N = 20;

	// 世代数
	public static final int T = 1000;

	public static void main(String[] args) {
		// エージェントの配列を生成
		Agent[] agents = new Agent[N];
		for (int i = 0; i < N; i++) {
			agents[i] = new Agent();
			agents[i].setAgentNumber(i);
		}

		//Double[] aveB = new Double[T];
		//Double[] aveV = new Double[T];


		// T世代のシミュレーションを行う
		for (int k = 0; k < T; k++) {
			Trial.oneGeneration(agents);
			// エージェントを得点の高い順に並び替え
			Arrays.sort(agents, (a,b)-> b.score - a.score );
			// 得点順に結果を出力
			//System.out.println(k + "世代の結果");
			//for(int n = 0; n < N; n++) {
			//	System.out.println("エージェント" + agents[n].num + "番：" + agents[n].score);
			//	System.out.println("B:" + agents[n].B + " R:" + agents[n].R + " RR:" + agents[n].RR);
			//}
			//double sumB = 0;
			//double sumV = 0;
			//for(int i = 0; i < N; i++) {
			//	sumB += agents[i].B;
			//	sumV += agents[i].V;
			//}
			//aveB[k] = sumB / N;
			//aveV[k] = sumV / N;
			// 進化を行う
			Evolution.evolution(agents);
		}
		//System.out.println("Bの結果");
		//for(int i = 0; i < T; i++) {
		//	System.out.println(aveB[i]);
		//}
		//System.out.println("Vの結果");
		//for(int i = 0; i < T; i++) {
		//	System.out.println(aveV[i]);
		//}
	}

}
