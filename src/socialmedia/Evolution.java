package socialmedia;

public class Evolution {
	static void evolution (Agent agents[]) {
		// 得点順の下位5人は上位5人のパラメータで上書きする
		for(int i = 0; i < 5; i++) {
			agents[i+15].B = agents[i].B;
			agents[i+15].R = agents[i].R;
			agents[i+15].RR = agents[i].RR;
		}
		// 突然変異
		for(int i = 0; i < agents.length; i++) {
			if(Math.random() < 0.06) {
				agents[i].B = Math.random();
			}
			if(Math.random() < 0.06) {
				agents[i].R = Math.random();
			}
			if(Math.random() < 0.06) {
				agents[i].RR = Math.random();
			}
		}
	}
}
