package com.vickykdv.mystockbit.network.mock

import com.vickykdv.mystockbit.BuildConfig
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor: Interceptor {

    private val SUCCESS_CODE = 200
    private val FAILED_CODE = 401

    private val getResponse1 = "{\"Message\":\"Success\",\"Type\":100,\"MetaData\":{\"Count\":3222},\"SponsoredData\":[{\"CoinInfo\":{\"Id\":\"939621\",\"Name\":\"STC\",\"FullName\":\"Student Coin\",\"Internal\":\"STC\",\"ImageUrl\":\"/media/37746407/student.png\",\"Url\":\"/coins/stc/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2020-06-25\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"}}],\"Data\":[{\"CoinInfo\":{\"Id\":\"213663\",\"Name\":\"FIL\",\"FullName\":\"FileCoin\",\"Internal\":\"FIL\",\"ImageUrl\":\"/media/37747014/fil.png\",\"Url\":\"/coins/fil/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":1002776,\"BlockTime\":30.25,\"BlockReward\":24.49237793834,\"AssetLaunchDate\":\"2017-07-19\",\"MaxSupply\":2000000000,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"FIL\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"516\",\"PRICE\":948900.3739768,\"LASTUPDATE\":1628390486,\"MEDIAN\":947340.9424,\"LASTVOLUME\":0.51,\"LASTVOLUMETO\":483939.190728168,\"LASTTRADEID\":\"7359018\",\"VOLUMEDAY\":39093.96170152347,\"VOLUMEDAYTO\":37096274878.81032,\"VOLUME24HOUR\":401576.1275303538,\"VOLUME24HOURTO\":381055737593.7078,\"OPENDAY\":986789.864802,\"HIGHDAY\":994687.9421544,\"LOWDAY\":944137.24732075,\"OPEN24HOUR\":976615.9659491701,\"HIGH24HOUR\":1031902.98295626,\"LOW24HOUR\":918256.75886709,\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":11167.890879369832,\"VOLUMEHOURTO\":10597215831.96613,\"OPENHOUR\":968176.7105229499,\"HIGHHOUR\":969602.4129508999,\"LOWHOUR\":944137.24732075,\"TOPTIERVOLUME24HOUR\":401576.1275303538,\"TOPTIERVOLUME24HOURTO\":381055737593.7078,\"CHANGE24HOUR\":-27715.59197237005,\"CHANGEPCT24HOUR\":-2.8379212442460275,\"CHANGEDAY\":-37889.49082519999,\"CHANGEPCTDAY\":-3.8396716643216173,\"CHANGEHOUR\":-19276.33654614992,\"CHANGEPCTHOUR\":-1.9909936209618202,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":94862295,\"MKTCAP\":90014867201797.53,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":12011146.633632125,\"TOTALVOLUME24HTO\":11397381532543.705,\"TOTALTOPTIERVOLUME24H\":12011146.633634081,\"TOTALTOPTIERVOLUME24HTO\":11397381532545.562,\"IMAGEURL\":\"/media/37747014/fil.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"FIL\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 948,900.4\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"FIL 0.5100\",\"LASTVOLUMETO\":\"IDR 483,939.2\",\"LASTTRADEID\":\"7359018\",\"VOLUMEDAY\":\"FIL 39,094.0\",\"VOLUMEDAYTO\":\"IDR 37,096,274,878.8\",\"VOLUME24HOUR\":\"FIL 401,576.1\",\"VOLUME24HOURTO\":\"IDR 381,055,737,593.7\",\"OPENDAY\":\"IDR 986,789.9\",\"HIGHDAY\":\"IDR 994,687.9\",\"LOWDAY\":\"IDR 944,137.2\",\"OPEN24HOUR\":\"IDR 976,616.0\",\"HIGH24HOUR\":\"IDR 1,031,903.0\",\"LOW24HOUR\":\"IDR 918,256.8\",\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":\"FIL 11,167.9\",\"VOLUMEHOURTO\":\"IDR 10,597,215,832.0\",\"OPENHOUR\":\"IDR 968,176.7\",\"HIGHHOUR\":\"IDR 969,602.4\",\"LOWHOUR\":\"IDR 944,137.2\",\"TOPTIERVOLUME24HOUR\":\"FIL 401,576.1\",\"TOPTIERVOLUME24HOURTO\":\"IDR 381,055,737,593.7\",\"CHANGE24HOUR\":\"IDR -27,716\",\"CHANGEPCT24HOUR\":\"-2.84\",\"CHANGEDAY\":\"IDR -37,889\",\"CHANGEPCTDAY\":\"-3.84\",\"CHANGEHOUR\":\"IDR -19,276\",\"CHANGEPCTHOUR\":\"-1.99\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"FIL 94,862,295.0\",\"MKTCAP\":\"IDR 90,014.87 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"FIL 12.01 M\",\"TOTALVOLUME24HTO\":\"IDR 11,397.38 B\",\"TOTALTOPTIERVOLUME24H\":\"FIL 12.01 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 11,397.38 B\",\"IMAGEURL\":\"/media/37747014/fil.png\"}}},{\"CoinInfo\":{\"Id\":\"3808\",\"Name\":\"LTC\",\"FullName\":\"Litecoin\",\"Internal\":\"LTC\",\"ImageUrl\":\"/media/37746243/ltc.png\",\"Url\":\"/coins/ltc/overview\",\"Algorithm\":\"Scrypt\",\"ProofType\":\"PoW\",\"Rating\":{\"Weiss\":{\"Rating\":\"C+\",\"TechnologyAdoptionRating\":\"B-\",\"MarketPerformanceRating\":\"D\"}},\"NetHashesPerSecond\":308520543676777,\"BlockNumber\":2100895,\"BlockTime\":137,\"BlockReward\":12.53708608,\"AssetLaunchDate\":\"2011-10-13\",\"MaxSupply\":84000000,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"LTC\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":2183416.60802768,\"LASTUPDATE\":1628390486,\"MEDIAN\":2178670.264,\"LASTVOLUME\":0.04766896,\"LASTVOLUMETO\":104081.1989514072,\"LASTTRADEID\":\"20475436\",\"VOLUMEDAY\":82326.79639769797,\"VOLUMEDAYTO\":179753694540.4471,\"VOLUME24HOUR\":614087.1924895898,\"VOLUME24HOURTO\":1340808174858.861,\"OPENDAY\":2221229.695674,\"HIGHDAY\":2247612.1769835,\"LOWDAY\":2168065.3333824,\"OPEN24HOUR\":2189818.84838065,\"HIGH24HOUR\":2276819.3134449,\"LOW24HOUR\":2110218.79249962,\"LASTMARKET\":\"Poloniex\",\"VOLUMEHOUR\":12221.757038130056,\"VOLUMEHOURTO\":26685187296.33235,\"OPENHOUR\":2188647.0263939,\"HIGHHOUR\":2191869.9497978,\"LOWHOUR\":2168065.3333824,\"TOPTIERVOLUME24HOUR\":614087.1924895898,\"TOPTIERVOLUME24HOURTO\":1340808174858.861,\"CHANGE24HOUR\":-6402.240352970082,\"CHANGEPCT24HOUR\":-0.2923639257970803,\"CHANGEDAY\":-37813.08764632,\"CHANGEPCTDAY\":-1.7023492761673242,\"CHANGEHOUR\":-5230.418366220314,\"CHANGEPCTHOUR\":-0.23897952950586804,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":68259233.23347135,\"MKTCAP\":149038343493196.28,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":4980822.940846548,\"TOTALVOLUME24HTO\":10875211530689.625,\"TOTALTOPTIERVOLUME24H\":4978335.9947171295,\"TOTALTOPTIERVOLUME24HTO\":10869781491207.38,\"IMAGEURL\":\"/media/37746243/ltc.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"Ł\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 2,183,416.6\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"Ł 0.04767\",\"LASTVOLUMETO\":\"IDR 104,081.2\",\"LASTTRADEID\":\"20475436\",\"VOLUMEDAY\":\"Ł 82,326.8\",\"VOLUMEDAYTO\":\"IDR 179,753,694,540.4\",\"VOLUME24HOUR\":\"Ł 614,087.2\",\"VOLUME24HOURTO\":\"IDR 1,340,808,174,858.9\",\"OPENDAY\":\"IDR 2,221,229.7\",\"HIGHDAY\":\"IDR 2,247,612.2\",\"LOWDAY\":\"IDR 2,168,065.3\",\"OPEN24HOUR\":\"IDR 2,189,818.8\",\"HIGH24HOUR\":\"IDR 2,276,819.3\",\"LOW24HOUR\":\"IDR 2,110,218.8\",\"LASTMARKET\":\"Poloniex\",\"VOLUMEHOUR\":\"Ł 12,221.8\",\"VOLUMEHOURTO\":\"IDR 26,685,187,296.3\",\"OPENHOUR\":\"IDR 2,188,647.0\",\"HIGHHOUR\":\"IDR 2,191,869.9\",\"LOWHOUR\":\"IDR 2,168,065.3\",\"TOPTIERVOLUME24HOUR\":\"Ł 614,087.2\",\"TOPTIERVOLUME24HOURTO\":\"IDR 1,340,808,174,858.9\",\"CHANGE24HOUR\":\"IDR -6,402.24\",\"CHANGEPCT24HOUR\":\"-0.29\",\"CHANGEDAY\":\"IDR -37,813\",\"CHANGEPCTDAY\":\"-1.70\",\"CHANGEHOUR\":\"IDR -5,230.42\",\"CHANGEPCTHOUR\":\"-0.24\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"Ł 68,259,233.2\",\"MKTCAP\":\"IDR 149,038.34 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"Ł 4.98 M\",\"TOTALVOLUME24HTO\":\"IDR 10,875.21 B\",\"TOTALTOPTIERVOLUME24H\":\"Ł 4.98 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 10,869.78 B\",\"IMAGEURL\":\"/media/37746243/ltc.png\"}}},{\"CoinInfo\":{\"Id\":\"925144\",\"Name\":\"OKB\",\"FullName\":\"Okex\",\"Internal\":\"OKB\",\"ImageUrl\":\"/media/37747532/okb.png\",\"Url\":\"/coins/okb/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2018-01-30\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"OKB\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"513\",\"PRICE\":331381,\"LASTUPDATE\":1628390255,\"MEDIAN\":331381,\"LASTVOLUME\":2.89989753,\"LASTVOLUMETO\":960970.94338893,\"LASTTRADEID\":\"1710813\",\"VOLUMEDAY\":403.37241174999997,\"VOLUMEDAYTO\":140174590.36268425,\"VOLUME24HOUR\":4884.9487246,\"VOLUME24HOURTO\":1626623692.90674,\"OPENDAY\":350000,\"HIGHDAY\":350000,\"LOWDAY\":327417,\"OPEN24HOUR\":305000,\"HIGH24HOUR\":350000,\"LOW24HOUR\":305000,\"LASTMARKET\":\"indodax\",\"VOLUMEHOUR\":26.09549111,\"VOLUMEHOURTO\":8600520.01078346,\"OPENHOUR\":333351,\"HIGHHOUR\":333351,\"LOWHOUR\":327417,\"TOPTIERVOLUME24HOUR\":4884.9487246,\"TOPTIERVOLUME24HOURTO\":1626623692.90674,\"CHANGE24HOUR\":26381,\"CHANGEPCT24HOUR\":8.649508196721312,\"CHANGEDAY\":-18619,\"CHANGEPCTDAY\":-5.319714285714286,\"CHANGEHOUR\":-1970,\"CHANGEPCTHOUR\":-0.590968678660031,\"CONVERSIONTYPE\":\"direct\",\"CONVERSIONSYMBOL\":\"\",\"SUPPLY\":269444872.26,\"MKTCAP\":89288911214391.06,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":27398983.49027675,\"TOTALVOLUME24HTO\":9079510392490.998,\"TOTALTOPTIERVOLUME24H\":27398983.49027675,\"TOTALTOPTIERVOLUME24HTO\":9079510392490.998,\"IMAGEURL\":\"/media/37747532/okb.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"OKB\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 331,381.0\",\"LASTUPDATE\":\"3 min ago\",\"LASTVOLUME\":\"OKB 2.90\",\"LASTVOLUMETO\":\"IDR 960,970.9\",\"LASTTRADEID\":\"1710813\",\"VOLUMEDAY\":\"OKB 403.37\",\"VOLUMEDAYTO\":\"IDR 140,174,590.4\",\"VOLUME24HOUR\":\"OKB 4,884.95\",\"VOLUME24HOURTO\":\"IDR 1,626,623,692.9\",\"OPENDAY\":\"IDR 350,000.0\",\"HIGHDAY\":\"IDR 350,000.0\",\"LOWDAY\":\"IDR 327,417.0\",\"OPEN24HOUR\":\"IDR 305,000.0\",\"HIGH24HOUR\":\"IDR 350,000.0\",\"LOW24HOUR\":\"IDR 305,000.0\",\"LASTMARKET\":\"indodax\",\"VOLUMEHOUR\":\"OKB 26.10\",\"VOLUMEHOURTO\":\"IDR 8,600,520.0\",\"OPENHOUR\":\"IDR 333,351.0\",\"HIGHHOUR\":\"IDR 333,351.0\",\"LOWHOUR\":\"IDR 327,417.0\",\"TOPTIERVOLUME24HOUR\":\"OKB 4,884.95\",\"TOPTIERVOLUME24HOURTO\":\"IDR 1,626,623,692.9\",\"CHANGE24HOUR\":\"IDR 26,381\",\"CHANGEPCT24HOUR\":\"8.65\",\"CHANGEDAY\":\"IDR -18,619\",\"CHANGEPCTDAY\":\"-5.32\",\"CHANGEHOUR\":\"IDR -1,970.00\",\"CHANGEPCTHOUR\":\"-0.59\",\"CONVERSIONTYPE\":\"direct\",\"CONVERSIONSYMBOL\":\"\",\"SUPPLY\":\"OKB 269,444,872.3\",\"MKTCAP\":\"IDR 89,288.91 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"OKB 27.40 M\",\"TOTALVOLUME24HTO\":\"IDR 9,079.51 B\",\"TOTALTOPTIERVOLUME24H\":\"OKB 27.40 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 9,079.51 B\",\"IMAGEURL\":\"/media/37747532/okb.png\"}}},{\"CoinInfo\":{\"Id\":\"940776\",\"Name\":\"SHIB\",\"FullName\":\"Shiba Inu\",\"Internal\":\"SHIB\",\"ImageUrl\":\"/media/37747199/shib.png\",\"Url\":\"/coins/shib/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2020-08-02\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"}},{\"CoinInfo\":{\"Id\":\"171986\",\"Name\":\"USDT\",\"FullName\":\"Tether\",\"Internal\":\"USDT\",\"ImageUrl\":\"/media/37746338/usdt.png\",\"Url\":\"/coins/usdt/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2014-10-06\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"USDT\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":14332.93443734263,\"LASTUPDATE\":1628390482,\"MEDIAN\":14318.1598062954,\"LASTVOLUME\":704.095072,\"LASTVOLUMETO\":10091748.50463204,\"LASTTRADEID\":\"102272854726\",\"VOLUMEDAY\":943016468.1477938,\"VOLUMEDAYTO\":13516193211296.73,\"VOLUME24HOUR\":7776014844.7654705,\"VOLUME24HOURTO\":111453110953826.5,\"OPENDAY\":14273.40657156961,\"HIGHDAY\":14375.03679105983,\"LOWDAY\":14254.82956956178,\"OPEN24HOUR\":14281.41747416904,\"HIGH24HOUR\":14333.71774171366,\"LOW24HOUR\":14243.01455087004,\"LASTMARKET\":\"HuobiPro\",\"VOLUMEHOUR\":185167787.19732633,\"VOLUMEHOURTO\":2653997753807.09,\"OPENHOUR\":14314.91898761873,\"HIGHHOUR\":14375.03679105983,\"LOWHOUR\":14337.47488923852,\"TOPTIERVOLUME24HOUR\":7776014844.7654705,\"TOPTIERVOLUME24HOURTO\":111453110953826.5,\"CHANGE24HOUR\":51.51696317358983,\"CHANGEPCT24HOUR\":0.36072724060317635,\"CHANGEDAY\":59.527865773019585,\"CHANGEPCTDAY\":0.41705436942845703,\"CHANGEHOUR\":18.01544972390002,\"CHANGEPCTHOUR\":0.12585086747247368,\"CONVERSIONTYPE\":\"invert_divide\",\"CONVERSIONSYMBOL\":\"ETH\",\"SUPPLY\":62432235031.20644,\"MKTCAP\":894837131479047.6,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24HTO\":0,\"TOTALVOLUME24H\":0,\"TOTALTOPTIERVOLUME24HTO\":0,\"TOTALTOPTIERVOLUME24H\":0,\"IMAGEURL\":\"/media/37746338/usdt.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"₮\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 14,332.9\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"₮ 704.10\",\"LASTVOLUMETO\":\"IDR 10,091,748.5\",\"LASTTRADEID\":\"102272854726\",\"VOLUMEDAY\":\"₮ 943,016,468.1\",\"VOLUMEDAYTO\":\"IDR 13,516,193,211,296.7\",\"VOLUME24HOUR\":\"₮ 7,776,014,844.8\",\"VOLUME24HOURTO\":\"IDR 111,453,110,953,826.5\",\"OPENDAY\":\"IDR 14,273.4\",\"HIGHDAY\":\"IDR 14,375.0\",\"LOWDAY\":\"IDR 14,254.8\",\"OPEN24HOUR\":\"IDR 14,281.4\",\"HIGH24HOUR\":\"IDR 14,333.7\",\"LOW24HOUR\":\"IDR 14,243.0\",\"LASTMARKET\":\"HuobiPro\",\"VOLUMEHOUR\":\"₮ 185,167,787.2\",\"VOLUMEHOURTO\":\"IDR 2,653,997,753,807.1\",\"OPENHOUR\":\"IDR 14,314.9\",\"HIGHHOUR\":\"IDR 14,375.0\",\"LOWHOUR\":\"IDR 14,337.5\",\"TOPTIERVOLUME24HOUR\":\"₮ 7,776,014,844.8\",\"TOPTIERVOLUME24HOURTO\":\"IDR 111,453,110,953,826.5\",\"CHANGE24HOUR\":\"IDR 51.52\",\"CHANGEPCT24HOUR\":\"0.36\",\"CHANGEDAY\":\"IDR 59.53\",\"CHANGEPCTDAY\":\"0.42\",\"CHANGEHOUR\":\"IDR 18.02\",\"CHANGEPCTHOUR\":\"0.13\",\"CONVERSIONTYPE\":\"invert_divide\",\"CONVERSIONSYMBOL\":\"ETH\",\"SUPPLY\":\"₮ 62,432,235,031.2\",\"MKTCAP\":\"IDR 894,837.13 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"₮ 0\",\"TOTALVOLUME24HTO\":\"IDR 0\",\"TOTALTOPTIERVOLUME24H\":\"₮ 0\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 0\",\"IMAGEURL\":\"/media/37746338/usdt.png\"}}},{\"CoinInfo\":{\"Id\":\"202330\",\"Name\":\"BCH\",\"FullName\":\"Bitcoin Cash\",\"Internal\":\"BCH\",\"ImageUrl\":\"/media/37746245/bch.png\",\"Url\":\"/coins/bch/overview\",\"Algorithm\":\"SHA-256\",\"ProofType\":\"PoW\",\"Rating\":{\"Weiss\":{\"Rating\":\"C\",\"TechnologyAdoptionRating\":\"C+\",\"MarketPerformanceRating\":\"E+\"}},\"NetHashesPerSecond\":1512710744315539000,\"BlockNumber\":699811,\"BlockTime\":543,\"BlockReward\":6.28000557,\"AssetLaunchDate\":\"2017-08-01\",\"MaxSupply\":20999999.9769,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"BCH\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":8177566.678059201,\"LASTUPDATE\":1628390486,\"MEDIAN\":8166081.44,\"LASTVOLUME\":0.044,\"LASTVOLUMETO\":359812.9338346048,\"LASTTRADEID\":\"300363806\",\"VOLUMEDAY\":15449.476620770116,\"VOLUMEDAYTO\":126339125207.4644,\"VOLUME24HOUR\":121551.58605803672,\"VOLUME24HOURTO\":993996199813.4464,\"OPENDAY\":8312148.861169999,\"HIGHDAY\":8410214.0750106,\"LOWDAY\":8130245.000184,\"OPEN24HOUR\":8209504.2298953,\"HIGH24HOUR\":8577932.7075165,\"LOW24HOUR\":7917902.5914288,\"LASTMARKET\":\"Exmo\",\"VOLUMEHOUR\":2129.006458349995,\"VOLUMEHOURTO\":17410092271.17575,\"OPENHOUR\":8193234.8336763,\"HIGHHOUR\":8205299.8985226,\"LOWHOUR\":8130245.000184,\"TOPTIERVOLUME24HOUR\":121551.58605803672,\"TOPTIERVOLUME24HOURTO\":993996199813.4464,\"CHANGE24HOUR\":-31937.551836099476,\"CHANGEPCT24HOUR\":-0.3890314316398956,\"CHANGEDAY\":-134582.1831107987,\"CHANGEPCTDAY\":-1.6191021763276654,\"CHANGEHOUR\":-15668.155617099255,\"CHANGEPCTHOUR\":-0.19123283947262332,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":18811306.14678923,\"MKTCAP\":153830710316753.84,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":1038926.1487723872,\"TOTALVOLUME24HTO\":8495887855165.448,\"TOTALTOPTIERVOLUME24H\":1038656.8074793528,\"TOTALTOPTIERVOLUME24HTO\":8493685298782.506,\"IMAGEURL\":\"/media/37746245/bch.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"BCH\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 8,177,566.7\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"BCH 0.04400\",\"LASTVOLUMETO\":\"IDR 359,812.9\",\"LASTTRADEID\":\"300363806\",\"VOLUMEDAY\":\"BCH 15,449.5\",\"VOLUMEDAYTO\":\"IDR 126,339,125,207.5\",\"VOLUME24HOUR\":\"BCH 121,551.6\",\"VOLUME24HOURTO\":\"IDR 993,996,199,813.4\",\"OPENDAY\":\"IDR 8,312,148.9\",\"HIGHDAY\":\"IDR 8,410,214.1\",\"LOWDAY\":\"IDR 8,130,245.0\",\"OPEN24HOUR\":\"IDR 8,209,504.2\",\"HIGH24HOUR\":\"IDR 8,577,932.7\",\"LOW24HOUR\":\"IDR 7,917,902.6\",\"LASTMARKET\":\"Exmo\",\"VOLUMEHOUR\":\"BCH 2,129.01\",\"VOLUMEHOURTO\":\"IDR 17,410,092,271.2\",\"OPENHOUR\":\"IDR 8,193,234.8\",\"HIGHHOUR\":\"IDR 8,205,299.9\",\"LOWHOUR\":\"IDR 8,130,245.0\",\"TOPTIERVOLUME24HOUR\":\"BCH 121,551.6\",\"TOPTIERVOLUME24HOURTO\":\"IDR 993,996,199,813.4\",\"CHANGE24HOUR\":\"IDR -31,938\",\"CHANGEPCT24HOUR\":\"-0.39\",\"CHANGEDAY\":\"IDR -134,582\",\"CHANGEPCTDAY\":\"-1.62\",\"CHANGEHOUR\":\"IDR -15,668\",\"CHANGEPCTHOUR\":\"-0.19\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"BCH 18,811,306.1\",\"MKTCAP\":\"IDR 153,830.71 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"BCH 1.04 M\",\"TOTALVOLUME24HTO\":\"IDR 8,495.89 B\",\"TOTALTOPTIERVOLUME24H\":\"BCH 1.04 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 8,493.69 B\",\"IMAGEURL\":\"/media/37746245/bch.png\"}}},{\"CoinInfo\":{\"Id\":\"309621\",\"Name\":\"LINK\",\"FullName\":\"Chainlink\",\"Internal\":\"LINK\",\"ImageUrl\":\"/media/37746242/link.png\",\"Url\":\"/coins/link/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2017-09-19\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"LINK\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":344903.5834824,\"LASTUPDATE\":1628390484,\"MEDIAN\":344559.0345,\"LASTVOLUME\":0.489,\"LASTVOLUMETO\":168657.8523228936,\"LASTTRADEID\":\"5131521\",\"VOLUMEDAY\":198492.753546509,\"VOLUMEDAYTO\":68460861993.47981,\"VOLUME24HOUR\":1281133.438904731,\"VOLUME24HOURTO\":441867513997.3721,\"OPENDAY\":351977.42217996,\"HIGHDAY\":356300.3614348801,\"LOWDAY\":342360.42390252,\"OPEN24HOUR\":346419.4217232,\"HIGH24HOUR\":376553.47870899,\"LOW24HOUR\":322624.86123852,\"LASTMARKET\":\"OKEX\",\"VOLUMEHOUR\":60738.62485076987,\"VOLUMEHOURTO\":20948969366.82368,\"OPENHOUR\":346307.22558768,\"HIGHHOUR\":346865.17539072,\"LOWHOUR\":343023.39916182,\"TOPTIERVOLUME24HOUR\":1281133.438904731,\"TOPTIERVOLUME24HOURTO\":441867513997.3721,\"CHANGE24HOUR\":-1515.838240800018,\"CHANGEPCT24HOUR\":-0.43757311101662777,\"CHANGEDAY\":-7073.838697560015,\"CHANGEPCTDAY\":-2.009742174298692,\"CHANGEHOUR\":-1403.6421052800142,\"CHANGEPCTHOUR\":-0.40531701378683255,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"ETH\",\"SUPPLY\":1000000000,\"MKTCAP\":344903583482400,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":24618634.710526112,\"TOTALVOLUME24HTO\":8491055332104.652,\"TOTALTOPTIERVOLUME24H\":24618634.710526112,\"TOTALTOPTIERVOLUME24HTO\":8491055332104.652,\"IMAGEURL\":\"/media/37746242/link.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"LINK\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 344,903.6\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"LINK 0.4890\",\"LASTVOLUMETO\":\"IDR 168,657.9\",\"LASTTRADEID\":\"5131521\",\"VOLUMEDAY\":\"LINK 198,492.8\",\"VOLUMEDAYTO\":\"IDR 68,460,861,993.5\",\"VOLUME24HOUR\":\"LINK 1,281,133.4\",\"VOLUME24HOURTO\":\"IDR 441,867,513,997.4\",\"OPENDAY\":\"IDR 351,977.4\",\"HIGHDAY\":\"IDR 356,300.4\",\"LOWDAY\":\"IDR 342,360.4\",\"OPEN24HOUR\":\"IDR 346,419.4\",\"HIGH24HOUR\":\"IDR 376,553.5\",\"LOW24HOUR\":\"IDR 322,624.9\",\"LASTMARKET\":\"OKEX\",\"VOLUMEHOUR\":\"LINK 60,738.6\",\"VOLUMEHOURTO\":\"IDR 20,948,969,366.8\",\"OPENHOUR\":\"IDR 346,307.2\",\"HIGHHOUR\":\"IDR 346,865.2\",\"LOWHOUR\":\"IDR 343,023.4\",\"TOPTIERVOLUME24HOUR\":\"LINK 1,281,133.4\",\"TOPTIERVOLUME24HOURTO\":\"IDR 441,867,513,997.4\",\"CHANGE24HOUR\":\"IDR -1,515.84\",\"CHANGEPCT24HOUR\":\"-0.44\",\"CHANGEDAY\":\"IDR -7,073.84\",\"CHANGEPCTDAY\":\"-2.01\",\"CHANGEHOUR\":\"IDR -1,403.64\",\"CHANGEPCTHOUR\":\"-0.41\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"ETH\",\"SUPPLY\":\"LINK 1,000,000,000.0\",\"MKTCAP\":\"IDR 344,903.58 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"LINK 24.62 M\",\"TOTALVOLUME24HTO\":\"IDR 8,491.06 B\",\"TOTALTOPTIERVOLUME24H\":\"LINK 24.62 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 8,491.06 B\",\"IMAGEURL\":\"/media/37746242/link.png\"}}},{\"CoinInfo\":{\"Id\":\"166503\",\"Name\":\"EOS\",\"FullName\":\"EOS\",\"Internal\":\"EOS\",\"ImageUrl\":\"/media/37746349/eos.png\",\"Url\":\"/coins/eos/overview\",\"Algorithm\":\"DPoS\",\"ProofType\":\"DPoS\",\"Rating\":{\"Weiss\":{\"Rating\":\"C\",\"TechnologyAdoptionRating\":\"C+\",\"MarketPerformanceRating\":\"D\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":198457975,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2017-06-26\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"EOS\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":63932.556758304,\"LASTUPDATE\":1628390486,\"MEDIAN\":63762.1228,\"LASTVOLUME\":186.62,\"LASTVOLUMETO\":11931093.74223469,\"LASTTRADEID\":\"56062423\",\"VOLUMEDAY\":1844987.8982460601,\"VOLUMEDAYTO\":117954793523.0002,\"VOLUME24HOUR\":11345373.269994805,\"VOLUME24HOURTO\":725338720528.0879,\"OPENDAY\":65404.991039,\"HIGHDAY\":66695.101762404,\"LOWDAY\":63548.90574989499,\"OPEN24HOUR\":63625.20208271001,\"HIGH24HOUR\":67347.93263299201,\"LOW24HOUR\":61828.06653183599,\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":279918.73970146844,\"VOLUMEHOURTO\":17895920713.67706,\"OPENHOUR\":64208.722561066,\"HIGHHOUR\":64303.274031532,\"LOWHOUR\":63548.90574989499,\"TOPTIERVOLUME24HOUR\":11345373.269994805,\"TOPTIERVOLUME24HOURTO\":725338720528.0879,\"CHANGE24HOUR\":307.35467559398967,\"CHANGEPCT24HOUR\":0.48307064737404193,\"CHANGEDAY\":-1472.4342806959976,\"CHANGEPCTDAY\":-2.2512567577878078,\"CHANGEHOUR\":-276.16580276199966,\"CHANGEPCTHOUR\":-0.4301063652206301,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":1031949166.5392,\"MKTCAP\":65975148661451.91,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":131335024.49898413,\"TOTALVOLUME24HTO\":8396583908134.549,\"TOTALTOPTIERVOLUME24H\":131332825.04582158,\"TOTALTOPTIERVOLUME24HTO\":8396443291470.397,\"IMAGEURL\":\"/media/37746349/eos.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"EOS\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 63,932.6\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"EOS 186.62\",\"LASTVOLUMETO\":\"IDR 11,931,093.7\",\"LASTTRADEID\":\"56062423\",\"VOLUMEDAY\":\"EOS 1,844,987.9\",\"VOLUMEDAYTO\":\"IDR 117,954,793,523.0\",\"VOLUME24HOUR\":\"EOS 11,345,373.3\",\"VOLUME24HOURTO\":\"IDR 725,338,720,528.1\",\"OPENDAY\":\"IDR 65,405.0\",\"HIGHDAY\":\"IDR 66,695.1\",\"LOWDAY\":\"IDR 63,548.9\",\"OPEN24HOUR\":\"IDR 63,625.2\",\"HIGH24HOUR\":\"IDR 67,347.9\",\"LOW24HOUR\":\"IDR 61,828.1\",\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":\"EOS 279,918.7\",\"VOLUMEHOURTO\":\"IDR 17,895,920,713.7\",\"OPENHOUR\":\"IDR 64,208.7\",\"HIGHHOUR\":\"IDR 64,303.3\",\"LOWHOUR\":\"IDR 63,548.9\",\"TOPTIERVOLUME24HOUR\":\"EOS 11,345,373.3\",\"TOPTIERVOLUME24HOURTO\":\"IDR 725,338,720,528.1\",\"CHANGE24HOUR\":\"IDR 307.35\",\"CHANGEPCT24HOUR\":\"0.48\",\"CHANGEDAY\":\"IDR -1,472.43\",\"CHANGEPCTDAY\":\"-2.25\",\"CHANGEHOUR\":\"IDR -276.17\",\"CHANGEPCTHOUR\":\"-0.43\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"EOS 1,031,949,166.5\",\"MKTCAP\":\"IDR 65,975.15 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"EOS 131.34 M\",\"TOTALVOLUME24HTO\":\"IDR 8,396.58 B\",\"TOTALTOPTIERVOLUME24H\":\"EOS 131.33 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 8,396.44 B\",\"IMAGEURL\":\"/media/37746349/eos.png\"}}},{\"CoinInfo\":{\"Id\":\"112392\",\"Name\":\"QTUM\",\"FullName\":\"QTUM\",\"Internal\":\"QTUM\",\"ImageUrl\":\"/media/37746863/qtum.png\",\"Url\":\"/coins/qtum/overview\",\"Algorithm\":\"POS 3.0\",\"ProofType\":\"PoS\",\"Rating\":{\"Weiss\":{\"Rating\":\"C-\",\"TechnologyAdoptionRating\":\"C-\",\"MarketPerformanceRating\":\"D\"}},\"NetHashesPerSecond\":7384251.56793915,\"BlockNumber\":1114565,\"BlockTime\":32,\"BlockReward\":1.00269176,\"AssetLaunchDate\":\"2016-12-19\",\"MaxSupply\":107822402.25,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"QTUM\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"2052\",\"PRICE\":148356.317605808,\"LASTUPDATE\":1628390486,\"MEDIAN\":148096.7312,\"LASTVOLUME\":56.02208,\"LASTVOLUMETO\":8311229.493417985,\"LASTTRADEID\":\"9203012\",\"VOLUMEDAY\":640080.2171907368,\"VOLUMEDAYTO\":94959943994.74352,\"VOLUME24HOUR\":6271848.817113294,\"VOLUME24HOURTO\":930468395087.2711,\"OPENDAY\":155257.4787285,\"HIGHDAY\":165590.037549678,\"LOWDAY\":147423.42400025,\"OPEN24HOUR\":136516.21029397,\"HIGH24HOUR\":167349.408360768,\"LOW24HOUR\":129399.056239554,\"LASTMARKET\":\"OKEX\",\"VOLUMEHOUR\":57838.668528199996,\"VOLUMEHOURTO\":8580731878.06669,\"OPENHOUR\":150114.69518206,\"HIGHHOUR\":151220.076651756,\"LOWHOUR\":147423.42400025,\"TOPTIERVOLUME24HOUR\":6215875.857113294,\"TOPTIERVOLUME24HOURTO\":922164452856.174,\"CHANGE24HOUR\":11840.107311837986,\"CHANGEPCT24HOUR\":8.673041308678176,\"CHANGEDAY\":-6901.161122691992,\"CHANGEPCTDAY\":-4.444978225338896,\"CHANGEHOUR\":-1758.377576252009,\"CHANGEPCTHOUR\":-1.1713560581923295,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":103629565,\"MKTCAP\":15374100658491.725,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":53782022.67623505,\"TOTALVOLUME24HTO\":7978902837638.295,\"TOTALTOPTIERVOLUME24H\":53378312.04623576,\"TOTALTOPTIERVOLUME24HTO\":7919009815193.279,\"IMAGEURL\":\"/media/37746863/qtum.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"QTUM\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 148,356.3\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"QTUM 56.02\",\"LASTVOLUMETO\":\"IDR 8,311,229.5\",\"LASTTRADEID\":\"9203012\",\"VOLUMEDAY\":\"QTUM 640,080.2\",\"VOLUMEDAYTO\":\"IDR 94,959,943,994.7\",\"VOLUME24HOUR\":\"QTUM 6,271,848.8\",\"VOLUME24HOURTO\":\"IDR 930,468,395,087.3\",\"OPENDAY\":\"IDR 155,257.5\",\"HIGHDAY\":\"IDR 165,590.0\",\"LOWDAY\":\"IDR 147,423.4\",\"OPEN24HOUR\":\"IDR 136,516.2\",\"HIGH24HOUR\":\"IDR 167,349.4\",\"LOW24HOUR\":\"IDR 129,399.1\",\"LASTMARKET\":\"OKEX\",\"VOLUMEHOUR\":\"QTUM 57,838.7\",\"VOLUMEHOURTO\":\"IDR 8,580,731,878.1\",\"OPENHOUR\":\"IDR 150,114.7\",\"HIGHHOUR\":\"IDR 151,220.1\",\"LOWHOUR\":\"IDR 147,423.4\",\"TOPTIERVOLUME24HOUR\":\"QTUM 6,215,875.9\",\"TOPTIERVOLUME24HOURTO\":\"IDR 922,164,452,856.2\",\"CHANGE24HOUR\":\"IDR 11,840\",\"CHANGEPCT24HOUR\":\"8.67\",\"CHANGEDAY\":\"IDR -6,901.16\",\"CHANGEPCTDAY\":\"-4.44\",\"CHANGEHOUR\":\"IDR -1,758.38\",\"CHANGEPCTHOUR\":\"-1.17\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"QTUM 103,629,565.0\",\"MKTCAP\":\"IDR 15,374.10 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"QTUM 53.78 M\",\"TOTALVOLUME24HTO\":\"IDR 7,978.90 B\",\"TOTALTOPTIERVOLUME24H\":\"QTUM 53.38 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 7,919.01 B\",\"IMAGEURL\":\"/media/37746863/qtum.png\"}}},{\"CoinInfo\":{\"Id\":\"930246\",\"Name\":\"MATIC\",\"FullName\":\"Polygon\",\"Internal\":\"MATIC\",\"ImageUrl\":\"/media/37746047/matic.png\",\"Url\":\"/coins/matic/overview\",\"Algorithm\":\"N/A\",\"ProofType\":\"N/A\",\"Rating\":{\"Weiss\":{\"Rating\":\"\",\"TechnologyAdoptionRating\":\"\",\"MarketPerformanceRating\":\"\"}},\"NetHashesPerSecond\":0,\"BlockNumber\":0,\"BlockTime\":0,\"BlockReward\":0,\"AssetLaunchDate\":\"2018-03-26\",\"MaxSupply\":-1,\"Type\":1,\"DocumentType\":\"Webpagecoinp\"},\"RAW\":{\"IDR\":{\"TYPE\":\"5\",\"MARKET\":\"CCCAGG\",\"FROMSYMBOL\":\"MATIC\",\"TOSYMBOL\":\"IDR\",\"FLAGS\":\"1026\",\"PRICE\":16317.3034408768,\"LASTUPDATE\":1628390486,\"MEDIAN\":16281.83264,\"LASTVOLUME\":966,\"LASTVOLUMETO\":15762515.12388699,\"LASTTRADEID\":\"17382747\",\"VOLUMEDAY\":2585899.0116368304,\"VOLUMEDAYTO\":42194898840.34157,\"VOLUME24HOUR\":30704739.314270806,\"VOLUME24HOURTO\":501018548463.9762,\"OPENDAY\":16624.29772234,\"HIGHDAY\":16794.9233309916,\"LOWDAY\":16191.4832912615,\"OPEN24HOUR\":16258.4011535624,\"HIGH24HOUR\":17213.2642212543,\"LOW24HOUR\":15738.0532990128,\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":871073.8009894599,\"VOLUMEHOURTO\":14213575530.14295,\"OPENHOUR\":16430.6210482885,\"HIGHHOUR\":16454.816193727,\"LOWHOUR\":16191.4832912615,\"TOPTIERVOLUME24HOUR\":30704739.314270806,\"TOPTIERVOLUME24HOURTO\":501018548463.9762,\"CHANGE24HOUR\":58.90228731440038,\"CHANGEPCT24HOUR\":0.362288313334514,\"CHANGEDAY\":-306.99428146320133,\"CHANGEPCTDAY\":-1.8466601512475165,\"CHANGEHOUR\":-113.31760741170001,\"CHANGEPCTHOUR\":-0.6896733061925482,\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":10000000000,\"MKTCAP\":163173034408768,\"MKTCAPPENALTY\":0,\"TOTALVOLUME24H\":451844461.04037595,\"TOTALVOLUME24HTO\":7372883178875.25,\"TOTALTOPTIERVOLUME24H\":451844414.64037514,\"TOTALTOPTIERVOLUME24HTO\":7372882421752.357,\"IMAGEURL\":\"/media/37746047/matic.png\"}},\"DISPLAY\":{\"IDR\":{\"FROMSYMBOL\":\"MATIC\",\"TOSYMBOL\":\"IDR\",\"MARKET\":\"CryptoCompare Index\",\"PRICE\":\"IDR 16,317.3\",\"LASTUPDATE\":\"Just now\",\"LASTVOLUME\":\"MATIC 966.00\",\"LASTVOLUMETO\":\"IDR 15,762,515.1\",\"LASTTRADEID\":\"17382747\",\"VOLUMEDAY\":\"MATIC 2,585,899.0\",\"VOLUMEDAYTO\":\"IDR 42,194,898,840.3\",\"VOLUME24HOUR\":\"MATIC 30,704,739.3\",\"VOLUME24HOURTO\":\"IDR 501,018,548,464.0\",\"OPENDAY\":\"IDR 16,624.3\",\"HIGHDAY\":\"IDR 16,794.9\",\"LOWDAY\":\"IDR 16,191.5\",\"OPEN24HOUR\":\"IDR 16,258.4\",\"HIGH24HOUR\":\"IDR 17,213.3\",\"LOW24HOUR\":\"IDR 15,738.1\",\"LASTMARKET\":\"Binance\",\"VOLUMEHOUR\":\"MATIC 871,073.8\",\"VOLUMEHOURTO\":\"IDR 14,213,575,530.1\",\"OPENHOUR\":\"IDR 16,430.6\",\"HIGHHOUR\":\"IDR 16,454.8\",\"LOWHOUR\":\"IDR 16,191.5\",\"TOPTIERVOLUME24HOUR\":\"MATIC 30,704,739.3\",\"TOPTIERVOLUME24HOURTO\":\"IDR 501,018,548,464.0\",\"CHANGE24HOUR\":\"IDR 58.90\",\"CHANGEPCT24HOUR\":\"0.36\",\"CHANGEDAY\":\"IDR -306.99\",\"CHANGEPCTDAY\":\"-1.85\",\"CHANGEHOUR\":\"IDR -113.32\",\"CHANGEPCTHOUR\":\"-0.69\",\"CONVERSIONTYPE\":\"multiply\",\"CONVERSIONSYMBOL\":\"BTC\",\"SUPPLY\":\"MATIC 10,000,000,000.0\",\"MKTCAP\":\"IDR 163,173.03 B\",\"MKTCAPPENALTY\":\"0 %\",\"TOTALVOLUME24H\":\"MATIC 451.84 M\",\"TOTALVOLUME24HTO\":\"IDR 7,372.88 B\",\"TOTALTOPTIERVOLUME24H\":\"MATIC 451.84 M\",\"TOTALTOPTIERVOLUME24HTO\":\"IDR 7,372.88 B\",\"IMAGEURL\":\"/media/37746047/matic.png\"}}}],\"RateLimit\":{},\"HasWarning\":false}"

    override fun intercept(chain: Interceptor.Chain): Response {
        return if (BuildConfig.DEBUG) {
            val uri = chain.request().url.toUri().toString()
            when {
//                uri.contains("totaltoptiervolfull") -> {
//                    mockResponse(chain, getResponse1)
//                }
                else -> {
                    chain.proceed(chain.request()).newBuilder().build()
                }
            }
        } else {
            chain.proceed(chain.request()).newBuilder().build()
        }
    }

    private fun mockResponse(chain: Interceptor.Chain, response: String): Response {
        return chain.proceed(chain.request())
            .newBuilder()
            .code(SUCCESS_CODE)
            .protocol(Protocol.HTTP_2)
            .message(response)
            .body(response.toByteArray().toResponseBody("application/json".toMediaTypeOrNull()))
            .addHeader("content-type", "application/json")
            .build()
    }

    private fun mockFailedResponse(chain: Interceptor.Chain, response: String): Response {
        return chain.proceed(chain.request())
            .newBuilder()
            .code(FAILED_CODE)
            .protocol(Protocol.HTTP_2)
            .message(response)
            .body(response.toByteArray().toResponseBody("application/json".toMediaTypeOrNull()))
            .addHeader("content-type", "application/json")
            .build()
    }
}