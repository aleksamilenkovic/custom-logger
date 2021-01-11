package logging;

public enum Level {
	INFO {
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "INFO";
		}
	},
	WARNING {
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "WARNING";
		}
	},
	ERROR {
		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "ERROR";
		}
	};

	public abstract String getValue();
}
