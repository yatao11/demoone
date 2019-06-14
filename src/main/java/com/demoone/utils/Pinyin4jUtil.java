package com.demoone.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * <pre>
 * 拼音工具类
 * </pre>
 *
 * @author lixin
 * @version 1.0
 * @since 2017/11/21 14:52
 */
public class Pinyin4jUtil {
    /**
     * 获取字符串中汉字的首字母，非汉字则不处理
     * @param str 字符串
     * @return 返回处理后的汉字首字母
     */
    public static String getHeadStr(String str){
        StringBuffer headStr=new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            String ch2=getHeadChar(ch);
            headStr.append(null==ch2 ? ch : ch2);
        }
        return headStr.toString();
    }

    /**
     * 获取指定汉字的拼音首字母
     * @param ch 要获取的汉字
     * @return 返回汉字首字母，如果非汉字返回null
     */
    public static String getHeadChar(char ch){
        String[] pinyins= PinyinHelper.toHanyuPinyinStringArray(ch);
        return null==pinyins ? null : String.valueOf(pinyins[0].charAt(0));
    }

    /**
     * 获取指定汉字的拼音数组<br>
     * 注：对声调支持不是很好，有些会显示乱码，例如“很”
     * @param ch 汉字字符
     * @param isShowMark 是否显示声调
     * @return 返回该汉字拼音字符串数组，非汉字返回null
     */
    public static String[] getPinyin(char ch,boolean isShowMark){
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //为true则设置输出格式带声调
        if(isShowMark){
            format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        }
        else{
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        }
        String[] pinyins=null;
        try {
            pinyins = PinyinHelper.toHanyuPinyinStringArray(ch,format);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return null==pinyins ? null : pinyins;
    }

    /**
     * 获取指定字符串的拼音字符串<br>
     * 注：对声调支持不是很好，有些会显示乱码，例如“很”
     * @param str 字符串
     * @param isShowMark 是否显示声调
     * @return 返回拼音字符串，非汉字则照原样输出
     */
    public static String getPinyins(String str,boolean isShowMark){
        StringBuffer pinyinStr=new StringBuffer();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //为true则设置输出格式带声调
        if(isShowMark){
            format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
            format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        }
        else{
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        }
        for (int i = 0; i < str.length(); i++) {
            try {
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i),format);
                if(null==pinyins)
                    pinyinStr.append(str.charAt(i));
                else
                    pinyinStr.append(pinyins[0]);
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        }
        return pinyinStr.toString();
    }
}
