package cn.pku.hzr.bean;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Cn2Spell {

    /**
     * 汉字转换位汉语拼音首字母，英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {

        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for ( int i = 0; i < nameChar.length; i++ )
        {
            if ( nameChar[i] > 128 )
            {
                try
                {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);
                }
                catch ( BadHanyuPinyinOutputFormatCombination e )
                {
                    System.err.println(e.getMessage());
                }
            } else
            {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    /**
     * 汉字转换位汉语拼音，英文字符不变
     *
     * @param chines 汉字
     * @return 拼音
     */
    public static String converterToSpell(String chines) {

        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for ( int i = 0; i < nameChar.length; i++ )
        {
            if ( nameChar[i] > 128 )
            {
                try
                {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
                }
                catch ( BadHanyuPinyinOutputFormatCombination e )
                {
                    System.err.println(e.getMessage());
                }
            } else
            {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

}
