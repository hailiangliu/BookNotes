package org.lig.shuapiao;

import java.util.HashMap;
import java.util.Map;

public class Shuapiao20190218 {

    public static void testList()throws Exception{
        {

            String openId = "oosnVwuKhibsUQmaGsZ14I-eXwcE";
            String name ="";
            String headImg = "";
            String otherPlayerId = "192";

            String url="https://12509052-17.hd.faisco.cn/ajax/hdgame_h.jsp";
            Map header =  new HashMap<String, String>();
            Map params =  new HashMap<String, String>();

            params.put("cmd","getMbtpPlayer");
            params.put("_openId","openId");

            params.put("aid","12509052");
            params.put("gameId","17");
            params.put("openId",openId);
            params.put("name",name);
            params.put("headImg",headImg);
            params.put("otherPlayerId",otherPlayerId);
            params.put("canal","-1");
            params.put("playerOrigin","2");


            header.put("playerOrigin", "XMLHttpRequest");
            header.put("Referer",
                    "https://12509052-17.hd.faisco.cn/12509052/GbzlzUXSnmSXy8KuKTTTZg/mbtp_new.html?otherplayer=oosnVwg5OkeAZkPw4wJxHcPVWtiE&shareDeep=8&canal=-1&isOfficialLianjie=false&from=singlemessage&appid=wx50775cad5d08d7ad");
            header.put("User-Agent", "Mozilla/5.0 (Linux; Android 9.0; EML-AL00 Build/HUAWEIEML-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044408 Mobile Safari/537.36 MMWEBID/3035 MicroMessenger/7.0.3.1400(0x27000338) Process/tools NetType/WIFI Language/zh_CN");
            header.put("Accept-Encoding", "gzip, deflate");
            header.put("Accept-Language", "zh-CN,en-US;q=0.8");
            header.put("Content-Type", "application/x-www-form-urlencoded");
            header.put("Cookie", "_cliid=oCYmKAnJCgKyAsCs; scope=snsapi_userinfo; faiOpenId="+openId+"; otherplayer_12509052_17=oosnVwg5OkeAZkPw4wJxHcPVWtiE; oid_12509052_17="+openId+"; _AID=12509052");

            HttpClientUtil utils = new HttpClientUtil();
            HttpResultVO result = utils.doPostDetail(url,header, params, "UTF-8");
            System.out.println(result.getResponseBody());
        }
    }

    public static void testVote(String _openId, String _name, String _otherPlayerId) throws Exception{

            String openId = _openId;
            String name = _name;
            String headImg = "";
            String otherPlayerId = "189";
            otherPlayerId = "210";//侯艳明
            otherPlayerId = _otherPlayerId;

            String url="https://12509052-17.hd.faisco.cn/ajax/hdgame_h.jsp";
            Map header =  new HashMap<String, String>();
            Map params =  new HashMap<String, String>();

            params.put("cmd","setMbPlayerVotes");
            params.put("_openId","openId");

            params.put("aid","12509052");
            params.put("gameId","17");
            params.put("openId",openId);
            params.put("name",name);
            params.put("headImg",headImg);
            params.put("otherPlayerId",otherPlayerId);
            params.put("canal","-1");
            params.put("playerOrigin","2");


            header.put("playerOrigin", "XMLHttpRequest");
            header.put("Referer",
                    "https://12509052-17.hd.faisco.cn/12509052/GbzlzUXSnmSXy8KuKTTTZg/mbtp_new.html?otherplayer=oosnVwg5OkeAZkPw4wJxHcPVWtiE&shareDeep=8&canal=-1&isOfficialLianjie=false&from=singlemessage&appid=wx50775cad5d08d7ad");
            header.put("User-Agent", "Mozilla/5.0 (Linux; Android 9.0; EML-AL00 Build/HUAWEIEML-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044408 Mobile Safari/537.36 MMWEBID/3035 MicroMessenger/7.0.3.1400(0x27000338) Process/tools NetType/WIFI Language/zh_CN");
            header.put("Accept-Encoding", "gzip, deflate");
            header.put("Accept-Language", "zh-CN,en-US;q=0.8");
            header.put("Content-Type", "application/x-www-form-urlencoded");
            header.put("Cookie", "_cliid=oCYmKAnJCgKyAsCs; scope=snsapi_userinfo; faiOpenId="+openId+"; otherplayer_12509052_17=oosnVwg5OkeAZkPw4wJxHcPVWtiE; oid_12509052_17="+openId+"; _AID=12509052");

            HttpClientUtil utils = new HttpClientUtil();
            HttpResultVO result = utils.doPostDetail(url,header, params, "UTF-8");
            System.out.println(result.getResponseBody());
    }
    public static void main(String[] args) throws Exception {
        //Shuapiao20190218.testList();
        String openId = "oeQDZt0n4VCZ70wykBlGpANiXqdM";
        String name = "";
        String otherPlayerId = "210";// 23 侯艳明
        //
        otherPlayerId = "193";// test  05 梁洪清 - 415票
        for (int i = 0; i < 1000 ; i++) {
            openId=openId+i;
            name=name+i;
            Shuapiao20190218.testVote(openId, name,otherPlayerId );
            Thread.currentThread().sleep(100);
        }

    }
}
