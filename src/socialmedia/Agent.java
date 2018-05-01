package socialmedia;

public class Agent {
	// 協力するか裏切るかの戦略
	int strategy;

	int num;

	int score;

	static double k0 = -1;
	static double k1 = -0.8;
	static double k2 = -0.64;
	static double p0 = 2;
	static double p1 = 1.6;
	static double p2 = 1.28;


	// 記事投稿（協調）率
	double B = Math.random();
	// コメント投稿（報酬）率
	double R = Math.random();
	// 返信（メタ報酬）率
	double RR = Math.random();

	// コンストラクタ
	Agent() {
		// 協力(1)、裏切り(0)だが、とりあえず2にセット
		this.strategy = 2;
	}

	// エージェントの番号をセット
	void setAgentNumber(int i) {
		this.num = i;
	}

	// 投稿するかしないかを決定
	void makeStrategy() {
		// 投稿する
		if(this.B > Math.random()) {
			this.strategy = 1;
		}
		// 投稿しない
		else {
			this.strategy = 0;
		}
	}

	void rewardCooperator(int target_num, double cost, double reward, Agent agents[]) {
		// 協力する（報酬を与える）
		if(this.R > Math.random()) {
			this.strategy = 1;
			this.getBenefit(cost);
			this.giveBenefitToSomeone(reward, target_num, agents);
		}
		// 裏切る（報酬を与えない）
		else {
			this.strategy = 0;
			// 何も発生しない
		}
	}

	void rewardRewarder(int target_num, double cost, double reward, Agent agents[]) {
		// 協力する（報酬を与える）
		if(this.RR > Math.random()) {
			this.strategy = 1;
			this.getBenefit(cost);
			this.giveBenefitToSomeone(reward, target_num, agents);
		}
		// 裏切る（報酬を与えない）
		else {
			this.strategy = 0;
			// 何も発生しない
		}
	}

	// 報酬を得る（benefit が負ならコスト）
	void getBenefit(double benefit) {
		this.score += benefit;
	}

	// 特定のエージェント1人に報酬を与える
	void giveBenefitToSomeone(double benefit, int target_num, Agent agents[]) {
		agents[target_num].score += benefit;
	}
}
