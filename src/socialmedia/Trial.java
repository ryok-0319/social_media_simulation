package socialmedia;

public class Trial {
	static void oneGeneration (Agent agents[]) {
		// 得点のリセット
		for(int k = 0; k < agents.length; k++) {
			agents[k].score = 0;
		}
		// 一人当たり、4回意思決定をする
		for (int i = 0; i < 4; i++) {
			// 最初の意思決定者は0番から順番に選ぶ
			for (int firstAgentNum = 0; firstAgentNum < agents.length; firstAgentNum++) {
				// 意思決定者が行動を決定
				agents[firstAgentNum].makeStrategy();
				// 記事を投稿した場合
				if (agents[firstAgentNum].strategy == 1) {
					//情報の価値をランダムに決定する
					double q = Math.random();
					// 他のエージェント全員について、情報から恩恵を受けたか判定
					for(int rewarderNum = 0; rewarderNum < agents.length; rewarderNum++) {
						// 投稿者本人は除外する
						if(rewarderNum == firstAgentNum) {
							continue;
						}
						// 恩恵を受けた場合
						if(q > Math.random()) {
							agents[rewarderNum].getBenefit(Agent.p0);
							// 恩恵を受けたエージェントは、確率Rで投稿者に報酬を与える
							agents[rewarderNum].rewardCooperator(firstAgentNum, Agent.k1, Agent.p1, agents);
							// 恩恵を受けたエージェントが、投稿者に報酬を与えた（コメントを投稿した）場合
							if(agents[rewarderNum].strategy == 1) {
								// 投稿者はRRの確率で、メタ報酬を与える
								agents[firstAgentNum].rewardRewarder(rewarderNum, Agent.k2, Agent.p2, agents);
							}
						}
					}
				}
			}
		}
		double sumB = 0;
		double sumR = 0;
		double sumRR = 0;
		for(int i = 0; i < agents.length; i++) {
			sumB += agents[i].B;
			sumR += agents[i].R;
			sumRR += agents[i].RR;
		}
		System.out.println(sumB / agents.length);
		//System.out.println(sumR / agents.length);
		//System.out.println(sumRR / agents.length);
	}
}
