package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式的威力，给我们文本处理带来哪些便利
 */
public class Regexp_ {
    public static void main(String[] args) {


        //假定，编写了爬虫，从百度页面得到如下文本
//        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的" +
//                "静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通" +
//                "过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的" +
//                "人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且" +
//                "重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结" +
//                "构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的" +
//                "语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以" +
//                "随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术），" +
//                "并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列" +
//                "名字之后，最终，使用了提议者在喝一杯Java咖啡时无意提到的Java词" +
//                "语）。5月23日，Sun公司在Sun world会议上正式发" +
//                "布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软" +
//                "等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产" +
//                "品开发了相应的Java平台";
//        String content = "<div class=\"cr-content  new-pmd\">\n" +
//                "    \n" +
//                "<div class=\"FYB_RD\">\n" +
//                "    <div class=\"cr-title c-gap-bottom-xsmall\" title=\"百度热榜\">\n" +
//                "        <span class=\"c-color-t\">百度热榜</span>\n" +
//                "                                                <div class=\"opr-toplist1-update opr-toplist1-link\" data-click=\"{fm:'beha'}\" style=\"position:relative;top:-1px;\">\n" +
//                "                    <a class=\"OP_LOG_BTN toplist-refresh-btn c-font-normal c-color-gray2\" href=\"javascript:void(0);\" style=\"text-decoration:none;\">\n" +
//                "                        <i class=\"c-icon opr-toplist1-hot-refresh-icon\">&#xe619;</i><span>换一换</span>\n" +
//                "                    </a>\n" +
//                "                </div>\n" +
//                "                        </div>\n" +
//                "    <table class=\"c-table opr-toplist1-table\">\n" +
//                "                        <tbody >\n" +
//                "                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single  toplist1-hot-top toplist1-hot-0 c-index-single-hot1 \" style=\"opacity:1;\">\n" +
//                "                        1\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"印度累计确诊病例已超2000万例\" href=\"/s?wd=%E5%8D%B0%E5%BA%A6%E7%B4%AF%E8%AE%A1%E7%A1%AE%E8%AF%8A%E7%97%85%E4%BE%8B%E5%B7%B2%E8%B6%852000%E4%B8%87%E4%BE%8B&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=abf2fwdknQ1VTZk3EzyT0N5%2FpcQzkjPt5GRZchjVdppW7k8B8oI6R5IL3T0myEMmjxXM&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_1\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        印度累计确诊病例已超2000万例\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">473万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single  toplist1-hot-top toplist1-hot-1 c-index-single-hot2 \" style=\"opacity:1;\">\n" +
//                "                        2\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"五一酒店外卖订单涨2倍\" href=\"/s?wd=%E4%BA%94%E4%B8%80%E9%85%92%E5%BA%97%E5%A4%96%E5%8D%96%E8%AE%A2%E5%8D%95%E6%B6%A82%E5%80%8D&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=32d1XGZJfky0Fpb6VgCcSv3Dnyp6JpbQ9TN%2BOvfioGkBC4T9m1Qp%2FFuwHnF9APvBaVr6&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_2\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        五一酒店外卖订单涨2倍\n" +
//                "                    </a>\n" +
//                "                                                                    <span class=\"c-text c-text-hot opr-toplist1-label\">热</span>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">441万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single  toplist1-hot-top toplist1-hot-2 c-index-single-hot3 \" style=\"opacity:1;\">\n" +
//                "                        3\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"印度籍无症状感染者密接曾参加婚宴\" href=\"/s?wd=%E5%8D%B0%E5%BA%A6%E7%B1%8D%E6%97%A0%E7%97%87%E7%8A%B6%E6%84%9F%E6%9F%93%E8%80%85%E5%AF%86%E6%8E%A5%E6%9B%BE%E5%8F%82%E5%8A%A0%E5%A9%9A%E5%AE%B4&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=79d48aiFJI7IvPi2BpW6Iy6VbHfAcV1uBdvZO8pb0chgf%2FK1Ic9Krgz3m43Aeg38VSM2&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_3\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        印度籍无症状感染者密接曾参加婚宴\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">425万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        4\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"这次是真正的国潮\" href=\"/s?wd=%E7%99%BE%E5%BA%A6%E5%9B%BD%E6%BD%AE%E5%AD%A3&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=fecdvAqz0R7aEIPJxobhfnLd1otn461fSeGWr8pqx3cGZkJ%2F98S1hWn6sBK8%2Fujuf6Nx&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_4\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        这次是真正的国潮\n" +
//                "                    </a>\n" +
//                "                                                                    <span class=\"c-text c-text-rec opr-toplist1-label\">荐</span>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">396万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        5\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"墨西哥轨交设施坍塌监控曝光\" href=\"/s?wd=%E5%A2%A8%E8%A5%BF%E5%93%A5%E8%BD%A8%E4%BA%A4%E8%AE%BE%E6%96%BD%E5%9D%8D%E5%A1%8C%E7%9B%91%E6%8E%A7%E6%9B%9D%E5%85%89&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=83bfOvia%2BOoGl9qutbaK5%2BfI3hDeC3FAdCyV%2F4cPmjZE6QeMZoMNyLCMOFpF7gkN8Tp4&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_5\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        墨西哥轨交设施坍塌监控曝光\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">382万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        6\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"印度供应全球六成新冠疫苗\" href=\"/s?wd=%E5%8D%B0%E5%BA%A6%E4%BE%9B%E5%BA%94%E5%85%A8%E7%90%83%E5%85%AD%E6%88%90%E6%96%B0%E5%86%A0%E7%96%AB%E8%8B%97&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=3b01YqbH3sPvmvx8Ck5Gq9NosRAi7F%2BITPb5d%2FbYkMlFMu2Fr%2FmPyqbcGiCPL1NUup5f&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_6\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        印度供应全球六成新冠疫苗\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">369万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        7\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"少女因病辍学4年写下500篇文章\" href=\"/s?wd=%E5%B0%91%E5%A5%B3%E5%9B%A0%E7%97%85%E8%BE%8D%E5%AD%A64%E5%B9%B4%E5%86%99%E4%B8%8B500%E7%AF%87%E6%96%87%E7%AB%A0&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=fac0t6ySTlYJYViu68pbr90yeoYsdLzmJ3yoFS63MgmLVAe1EOH2pJPITFtCLWasq1Y5&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_7\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        少女因病辍学4年写下500篇文章\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">356万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        8\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"售价2200元的“神药”成本仅50元\" href=\"/s?wd=%E5%94%AE%E4%BB%B72200%E5%85%83%E7%9A%84%E2%80%9C%E7%A5%9E%E8%8D%AF%E2%80%9D%E6%88%90%E6%9C%AC%E4%BB%8550%E5%85%83&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=cdddugWl4sZtX04FYWIZbl9Cyyc7pZWX9sh0KvfPqgzqNBivbI2vdiJMrq72Bq4gXqHk&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_8\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        售价2200元的“神药”成本仅50元\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">343万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        9\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"央视五四晚会节目单出炉\" href=\"/s?wd=%E5%A4%AE%E8%A7%86%E4%BA%94%E5%9B%9B%E6%99%9A%E4%BC%9A%E8%8A%82%E7%9B%AE%E5%8D%95%E5%87%BA%E7%82%89&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=2f67NoNuMuoV3aLTdna3uIzyEJGhxDThWFkMH0z1ZV0obHc0WxGWL2QaN0roTrKMjCYC&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_9\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        央视五四晚会节目单出炉\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">331万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        10\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"91岁巴菲特选出继任者\" href=\"/s?wd=91%E5%B2%81%E5%B7%B4%E8%8F%B2%E7%89%B9%E9%80%89%E5%87%BA%E7%BB%A7%E4%BB%BB%E8%80%85&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=7d429xUUJZLFLSMjZR6habx13%2BdASsly6zcvmnhdiq5T%2BY8PaleKBxypUgU7onDWZfXf&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_10\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        91岁巴菲特选出继任者\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">320万</td>\n" +
//                "            </tr>\n" +
//                "                </tbody>\n" +
//                "                                <tbody style=\"display:none\">\n" +
//                "                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        11\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"8旬退休教授为贫困生捐70万\" href=\"/s?wd=8%E6%97%AC%E9%80%80%E4%BC%91%E6%95%99%E6%8E%88%E4%B8%BA%E8%B4%AB%E5%9B%B0%E7%94%9F%E6%8D%9070%E4%B8%87&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=f57amyz02ho2MnkxxIB0zWHTw9CDEypEMVB2PBlBNcy37%2FJ9T1VwBcokXXZOxr2jvv9G&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_11\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        8旬退休教授为贫困生捐70万\n" +
//                "                    </a>\n" +
//                "                                                                    <span class=\"c-text c-text-new opr-toplist1-label\">新</span>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">309万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        12\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"女子为给偶像删帖被骗8000元\" href=\"/s?wd=%E5%A5%B3%E5%AD%90%E4%B8%BA%E7%BB%99%E5%81%B6%E5%83%8F%E5%88%A0%E5%B8%96%E8%A2%AB%E9%AA%978000%E5%85%83&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=86c1ICmWkGtTaB7UqvG0ysxoljgkHlWe%2BWHEX0V8s8zxcKIzmN2gkudtAYvsBpNvYDOj&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_12\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        女子为给偶像删帖被骗8000元\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">298万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        13\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"比尔·盖茨夫妇离婚 女儿发声\" href=\"/s?wd=%E6%AF%94%E5%B0%94%C2%B7%E7%9B%96%E8%8C%A8%E5%A4%AB%E5%A6%87%E7%A6%BB%E5%A9%9A+%E5%A5%B3%E5%84%BF%E5%8F%91%E5%A3%B0&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=896490eILJu%2FQTiRLPviDBzceznJ4WDcrcARkLwmE0XCIpTu3PrKFwO6F4UrH7PInzJf&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_13\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        比尔·盖茨夫妇离婚 女儿发声\n" +
//                "                    </a>\n" +
//                "                                                                    <span class=\"c-text c-text-hot opr-toplist1-label\">热</span>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">287万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        14\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"学生18种语言演唱追梦赤子心\" href=\"/s?wd=%E5%AD%A6%E7%94%9F18%E7%A7%8D%E8%AF%AD%E8%A8%80%E6%BC%94%E5%94%B1%E8%BF%BD%E6%A2%A6%E8%B5%A4%E5%AD%90%E5%BF%83&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=3f72LcjlesGwBj0Clhi%2Bb%2F2VReCDWnVIAhD2gY8ek2xyxp7CdywyGDo4umYaRhP3221H&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_14\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        学生18种语言演唱追梦赤子心\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">277万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        15\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"少林寺500多年古碑遭熊孩子刻画\" href=\"/s?wd=%E5%B0%91%E6%9E%97%E5%AF%BA500%E5%A4%9A%E5%B9%B4%E5%8F%A4%E7%A2%91%E9%81%AD%E7%86%8A%E5%AD%A9%E5%AD%90%E5%88%BB%E7%94%BB&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=c269Co2zIeZtuzyqqsvebsim1bobIW%2B%2BjfTjg71RfZnwmws3ig67InXI3vNu4fzOeXWU&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_15\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        少林寺500多年古碑遭熊孩子刻画\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">268万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        16\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"比尔·盖茨发文希望保护隐私\" href=\"/s?wd=%E6%AF%94%E5%B0%94%C2%B7%E7%9B%96%E8%8C%A8%E5%8F%91%E6%96%87%E5%B8%8C%E6%9C%9B%E4%BF%9D%E6%8A%A4%E9%9A%90%E7%A7%81&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=10dcmr4dz3wKqdfJkFOOE0IXaxZmGtm1I6jFQji1C3vuy4HISFpAUfeeI7sh133z7hSq&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_16\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        比尔·盖茨发文希望保护隐私\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">258万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        17\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"韩国青年排队抢购奢侈品\" href=\"/s?wd=%E9%9F%A9%E5%9B%BD%E9%9D%92%E5%B9%B4%E6%8E%92%E9%98%9F%E6%8A%A2%E8%B4%AD%E5%A5%A2%E4%BE%88%E5%93%81&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=d978WNnZlLwmlF%2BvU8n7Zc%2FcwTRpOrntJEL93BpoZZKZqw3IqNftMckCKsE4lxm1cKDq&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_17\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        韩国青年排队抢购奢侈品\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">249万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        18\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"李开复谈盖茨夫妇离婚\" href=\"/s?wd=%E6%9D%8E%E5%BC%80%E5%A4%8D%E8%B0%88%E7%9B%96%E8%8C%A8%E5%A4%AB%E5%A6%87%E7%A6%BB%E5%A9%9A&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=8b26lOeJYdFsbzrlKHrtA%2BqP%2B72mxliaQQeuWBA4WevfUhj2awgHfQiliYz%2FKHekOWLq&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_18\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        李开复谈盖茨夫妇离婚\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">240万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal opr-toplist1-one-font\" style=\"opacity:1;\">\n" +
//                "                        19\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"秦昊看伊能静演出\" href=\"/s?wd=%E7%A7%A6%E6%98%8A%E7%9C%8B%E4%BC%8A%E8%83%BD%E9%9D%99%E6%BC%94%E5%87%BA&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=1b57U64YpaHqGvduMc0cFIo7gLTIrQ4lM21aDbL4sxYl0oynCKAEFut9HCWJNIzytl%2Fa&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_19\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        秦昊看伊能静演出\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">232万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        20\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"医生景区救人获终身免门票\" href=\"/s?wd=%E5%8C%BB%E7%94%9F%E6%99%AF%E5%8C%BA%E6%95%91%E4%BA%BA%E8%8E%B7%E7%BB%88%E8%BA%AB%E5%85%8D%E9%97%A8%E7%A5%A8&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=a286ytHBPeiBaO6ftRxaSzW%2FHXDoDA1d%2BMHbSGjzMIU9mhXPBiNYKGK0S142wLZGMl1B&rsf=dd45f07d69719294a2ea6117b312f1d7_11_20_20\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        医生景区救人获终身免门票\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">224万</td>\n" +
//                "            </tr>\n" +
//                "                </tbody>\n" +
//                "                                <tbody style=\"display:none\">\n" +
//                "                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        21\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"31省区市新增确诊17例均为境外输入\" href=\"/s?wd=31%E7%9C%81%E5%8C%BA%E5%B8%82%E6%96%B0%E5%A2%9E%E7%A1%AE%E8%AF%8A17%E4%BE%8B%E5%9D%87%E4%B8%BA%E5%A2%83%E5%A4%96%E8%BE%93%E5%85%A5&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=df27aIqxHhQIcAkMctyNR3AZ7%2Bc%2BAFGjTdYqB9bg2gSDU95OAwTih0Zlw%2B45tFVdw%2Fb%2B&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_21\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        31省区市新增确诊17例均为境外输入\n" +
//                "                    </a>\n" +
//                "                                                                    <span class=\"c-text c-text-hot opr-toplist1-label\">热</span>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">216万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        22\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"95后00后成红色旅游出游主力\" href=\"/s?wd=95%E5%90%8E00%E5%90%8E%E6%88%90%E7%BA%A2%E8%89%B2%E6%97%85%E6%B8%B8%E5%87%BA%E6%B8%B8%E4%B8%BB%E5%8A%9B&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=9684bWy5j1gUATPXvoTZQmKIrX6gg%2Fyj%2F5x1JWcvXjz%2FpWmHSKBymZqnL6Bb3Ypms7Aq&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_22\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        95后00后成红色旅游出游主力\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">208万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        23\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"男子爬玻璃栈桥防护栏被逐出景区\" href=\"/s?wd=%E7%94%B7%E5%AD%90%E7%88%AC%E7%8E%BB%E7%92%83%E6%A0%88%E6%A1%A5%E9%98%B2%E6%8A%A4%E6%A0%8F%E8%A2%AB%E9%80%90%E5%87%BA%E6%99%AF%E5%8C%BA&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=d38b0oqpz16NpoH6i3B45MNJZgknKbf4Lyjmkh7DPDc%2FD1v8u%2BK9diDAcH%2FzyUUwJufK&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_23\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        男子爬玻璃栈桥防护栏被逐出景区\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">201万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        24\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"美国近三分之一人完成疫苗两针接种\" href=\"/s?wd=%E7%BE%8E%E5%9B%BD%E8%BF%91%E4%B8%89%E5%88%86%E4%B9%8B%E4%B8%80%E4%BA%BA%E5%AE%8C%E6%88%90%E7%96%AB%E8%8B%97%E4%B8%A4%E9%92%88%E6%8E%A5%E7%A7%8D&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=8543F244DfP53qkV4K1yeWjVehoD8tduIx%2B0VOZb%2BVVSNxNFMdIpULyxiQ%2BlsUdv51hM&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_24\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        美国近三分之一人完成疫苗两针接种\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">194万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        25\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"萧敬腾在广州参加活动下大雨\" href=\"/s?wd=%E8%90%A7%E6%95%AC%E8%85%BE%E5%9C%A8%E5%B9%BF%E5%B7%9E%E5%8F%82%E5%8A%A0%E6%B4%BB%E5%8A%A8%E4%B8%8B%E5%A4%A7%E9%9B%A8&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=04613AvycY3GvCKQQB6P6T0DRTH5ObmzFA5b0Bz4CrxddgOpuldpmQfSbhVStcmZoHjI&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_25\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        萧敬腾在广州参加活动下大雨\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">187万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        26\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"女子夜店内抱娃蹦迪\" href=\"/s?wd=%E5%A5%B3%E5%AD%90%E5%A4%9C%E5%BA%97%E5%86%85%E6%8A%B1%E5%A8%83%E8%B9%A6%E8%BF%AA&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=466c7vsJ6Lu%2BEK8aRHLwwL%2Bf8wHeXjubIYyiewtTQq%2BqQcV9CTRxakAwZDoh25aVmsQA&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_26\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        女子夜店内抱娃蹦迪\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">181万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        27\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"姚明说CBA要给年轻球员机会\" href=\"/s?wd=%E5%A7%9A%E6%98%8E%E8%AF%B4CBA%E8%A6%81%E7%BB%99%E5%B9%B4%E8%BD%BB%E7%90%83%E5%91%98%E6%9C%BA%E4%BC%9A&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=5dcdVKFZQj03MQo3bSpvWCa2nmuarhCkyaGwUTpme7K7Tp4Fvbr9Xe%2FWFNJOFSHLFv3w&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_27\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        姚明说CBA要给年轻球员机会\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">174万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single toplist1-hot-normal \" style=\"opacity:1;\">\n" +
//                "                        28\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"黄秋生在台隔离期间被诈骗\" href=\"/s?wd=%E9%BB%84%E7%A7%8B%E7%94%9F%E5%9C%A8%E5%8F%B0%E9%9A%94%E7%A6%BB%E6%9C%9F%E9%97%B4%E8%A2%AB%E8%AF%88%E9%AA%97&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=9f9app%2FvUpebIOcqeTXr8MAHsM5IZp4JJ8oCLPiLfIu6DeChK1Z3jv6Ttr3i3hUUNhcW&rsf=dd45f07d69719294a2ea6117b312f1d7_21_30_28\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        黄秋生在台隔离期间被诈骗\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">168万</td>\n" +
//                "            </tr>\n" +
//                "                        </tbody>    </table>\n" +
//                "    </div>";

        String content = "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";

        //提取文章中所有的英文单词
        //提取文章中所有的数字
        //提取文章中所有的英文单词和数字
        //提取百度热榜 标题
        //(1). 传统方法. 使用遍历方式，代码量大，效率不高
        //(2). 正则表达式技术

        //1. 先创建一个Pattern对象 ， 模式对象, 可以理解成就是一个正则表达式对象
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //Pattern pattern = Pattern.compile("[0-9]+");
        //Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");
        //Pattern pattern = Pattern.compile("<a target=\"_blank\" title=\"(\\S*)\"");

        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        //2. 创建一个匹配器对象
        //理解： 就是 matcher 匹配器按照 pattern(模式/样式), 到 content 文本中去匹配
        //找到就返回true, 否则就返回false
        int no = 0;
        Matcher matcher = pattern.matcher(content);
        //3. 可以开始循环匹配
        while (matcher.find()) {
            //匹配内容，文本，放到 m.group(0)
            System.out.println("找到: " + (++no) + " " +matcher.group(0));
        }
    }
}
