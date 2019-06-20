package com.rfchina.community.base;

public class OpenOperatorTaskConstant {
	//任务领取状态
	public static interface ReceiveStatus {
		// 0未领取，1已领取
		public int no_receive = 0;
		public int receive= 1;

		public static String getLabel(Integer receiveStatus) {
			if(receiveStatus == null)
				return "-";

			if (no_receive == receiveStatus)
				return "未领取";

			return "已领取";
		}
	}

	//任务领取状态
	public static interface RelValidStatus {
		// 0无效，1有效
		public int invalid = 0;
		public int valid= 1;
	}

	//推送类型
	public static interface PushType {
		//81:运营新任务82:运营新任务(重新释放)83:任务取消通知

		public int publish = 81;
		public int quit_operator= 82;
		public int stop_task= 83;
	}


	//发布状态
	public enum ReleaseStatus {
		no_start(0, "未发布"),
		running(1, "已发布"),
		stop(2, "已停止");
		private int code;
		private String label;

		ReleaseStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static String getLabel(Integer releaseStatus) {
			if(releaseStatus == null)
				return "-";
			for (ReleaseStatus record : ReleaseStatus.values()) {
				if (record.getCode() == releaseStatus)
					return record.getLabel();
			}
			return "-";
		}
	}


	// 0“-”：任务未发布时，显示为-
	//1未被领取：任务已发布，未被运营者领取。若运营者被剔除，但是未到任务结束时间，此时也会更新为未被领取
	//2筹备中：任务被领取，但未到任务开始时间
	//3进行中：任务被领取，且到了任务开始时间
	//4已结束：任务被领取，到了任务结束时间或者任务被停用
	public enum RateStatus {
		no_release(0, "-"),
		no_receive(1, "未被领取"),
		before_running(2, "筹备中"),
		running(3, "进行中"),
		over(4, "已结束");
		private int code;
		private String label;

		RateStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static String getLabel(Integer rateStatus) {
			if(rateStatus == null)
				return "-";
			for (RateStatus record : RateStatus.values()) {
				if (record.getCode() == rateStatus)
					return record.getLabel();
			}
			return "-";
		}
	}



	//0筹备中未到任务开始时间
	//1进行中：
	//2已结束任务结束时间
	public enum TimeStatus {
		no_start(0, "未开始"),
		running(1, "进行中"),
		over(2, "已结束");

		private int code;
		private String label;

		TimeStatus(int code, String label) {
			this.code = code;
			this.label = label;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public static String getLabel(Integer timeStatus) {
			if(timeStatus == null)
				return "-";
			for (TimeStatus record : TimeStatus.values()) {
				if (record.getCode() == timeStatus)
					return record.getLabel();
			}
			return "-";
		}
	}
}
