package com.xiaoyao.sys;

public class Type {
	public static enum BoolType {
		NO(0,"否"),
		YES(1,"是");
		public  static BoolType get(int i){
			switch(i)
			{
				case 0:
					return BoolType.NO;
				case 1:
					return BoolType.YES;
			}
			return null;
		}


		private   int   nCode ;
		private   String   nLabel ;
		private   BoolType ( int   _nCode,String _nlabel) {

			this. nCode  = _nCode;
			this.nLabel=_nlabel;
		}

		public int val(){
			return nCode;
		}


	}
}
