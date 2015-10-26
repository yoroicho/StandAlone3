/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psManage;

/**
 *
 * @author 
 */
public class StructSheet {

    private String mainTitle; //
    private String subTitle; //
    private String url; // アクセス先、もしくはプログラム名
    private String userName; // パスワードと対になるユーザー名
    private String scanType; //ランダム分割、順読み分割、循環更新、使い捨て更新など
    private String comment; //
    private String thisPassCode; //シートそのものを暗号化する時のパスコード
    private String randomType; // 文字種の分類
    private String randomText; // 具体的な文字指定
    private int passLength; // ひとつあたりの文字数
    private String[] passCode; // 

    /**
     *
     * @param mainTitle
     * @param subTitle
     * @param url
     * @param userName
     * @param scanType
     * @param comment
     * @param thisPassCode
     * @param passCode
     */
    public StructSheet( // コンストラクタ
            String mainTitle,
            String subTitle,
            String url,
            String userName,
            String scanType,
            String comment,
            String thisPassCode,
            String... passCode) {
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.url = url;
        this.userName = userName;
        this.scanType = scanType;
        this.comment = comment;
        this.thisPassCode = thisPassCode;
        this.passCode = passCode;
    }

    
}
