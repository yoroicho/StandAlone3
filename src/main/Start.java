package main;

import java.io.File;

public class Start {

	public static void main(String[] args) {
		// 開始
		// 設定ファイルがあれば読み込み
		File file = new File("Properties.xml");
		if (file.exists()){
		    System.out.println("設定ファイルは存在します");
		    // 設定ファイルの読み込み
		}else{
		    System.out.println("設定ファイルは存在しません");
		}
			

	}

}
