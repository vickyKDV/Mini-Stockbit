package com.vickykdv.mystockbit.model

import com.google.gson.annotations.SerializedName

data class CryptoModel(

	@field:SerializedName("RateLimit")
	val rateLimit: RateLimit,

	@field:SerializedName("Type")
	val type: Int,

	@field:SerializedName("Message")
	val message: String,

	@field:SerializedName("MetaData")
	val metaData: MetaData,

	@field:SerializedName("HasWarning")
	val hasWarning: Boolean,

	@field:SerializedName("Data")
	val data: List<DataItem>,

	@field:SerializedName("SponsoredData")
	val sponsoredData: List<SponsoredDataItem>
)

data class Weiss(

	@field:SerializedName("Rating")
	val rating: String,

	@field:SerializedName("TechnologyAdoptionRating")
	val technologyAdoptionRating: String,

	@field:SerializedName("MarketPerformanceRating")
	val marketPerformanceRating: String
)

data class RAW(

	@field:SerializedName("IDR")
	val rawIDR: RawIDR
)

//data class DISPLAY(
//
//	@field:SerializedName("IDR")
//	val iDR: IDR
//)

data class RateLimit(
	val any: Any? = null
)

data class CoinInfo(

	@field:SerializedName("Internal")
	val internal: String,

	@field:SerializedName("Rating")
	val rating: Rating,

	@field:SerializedName("BlockTime")
	val blockTime: Double,

	@field:SerializedName("ImageUrl")
	val imageUrl: String,

	@field:SerializedName("MaxSupply")
	val maxSupply: Double,

	@field:SerializedName("DocumentType")
	val documentType: String,

	@field:SerializedName("Algorithm")
	val algorithm: String,

	@field:SerializedName("Url")
	val url: String,

	@field:SerializedName("Name")
	val name: String,

	@field:SerializedName("Type")
	val type: Int,

	@field:SerializedName("ProofType")
	val proofType: String,

	@field:SerializedName("NetHashesPerSecond")
	val netHashesPerSecond: Double,

	@field:SerializedName("AssetLaunchDate")
	val assetLaunchDate: String,

	@field:SerializedName("FullName")
	val fullName: String,

	@field:SerializedName("Id")
	val id: String,

	@field:SerializedName("BlockNumber")
	val blockNumber: Int,

	@field:SerializedName("BlockReward")
	val blockReward: Double
)

data class DataItem(

//	@field:SerializedName("DISPLAY")
//	val dISPLAY: DISPLAY,

	@field:SerializedName("RAW")
	val rAW: RAW,

	@field:SerializedName("CoinInfo")
	val coinInfo: CoinInfo
)

data class SponsoredDataItem(

	@field:SerializedName("CoinInfo")
	val coinInfSponsored: CoinInfSponsored
)

data class RawIDR(

	@field:SerializedName("CONVERSIONTYPE")
	val cONVERSIONTYPE: String,

	@field:SerializedName("LASTTRADEID")
	val lASTTRADEID: String,

	@field:SerializedName("OPEN24HOUR")
	val oPEN24HOUR: Double,

	@field:SerializedName("HIGHDAY")
	val hIGHDAY: Double,

	@field:SerializedName("LOW24HOUR")
	val lOW24HOUR: Double,

	@field:SerializedName("TOPTIERVOLUME24HOUR")
	val tOPTIERVOLUME24HOUR: Double,

	@field:SerializedName("TOTALVOLUME24HTO")
	val tOTALVOLUME24HTO: Double,

	@field:SerializedName("TOSYMBOL")
	val tOSYMBOL: String,

	@field:SerializedName("LASTVOLUME")
	val lASTVOLUME: Double,

	@field:SerializedName("LASTMARKET")
	val lASTMARKET: String,

	@field:SerializedName("LOWHOUR")
	val lOWHOUR: Double,

	@field:SerializedName("CONVERSIONSYMBOL")
	val cONVERSIONSYMBOL: String,

	@field:SerializedName("MKTCAP")
	val mKTCAP: Double,

	@field:SerializedName("LASTUPDATE")
	val lASTUPDATE: Int,

	@field:SerializedName("CHANGEPCTHOUR")
	val cHANGEPCTHOUR: Double,

	@field:SerializedName("TOTALVOLUME24H")
	val tOTALVOLUME24H: Double,

	@field:SerializedName("VOLUMEHOURTO")
	val vOLUMEHOURTO: Double,

	@field:SerializedName("VOLUMEHOUR")
	val vOLUMEHOUR: Double,

	@field:SerializedName("TOPTIERVOLUME24HOURTO")
	val tOPTIERVOLUME24HOURTO: Double,

	@field:SerializedName("CHANGEDAY")
	val cHANGEDAY: Double,

	@field:SerializedName("FLAGS")
	val fLAGS: String,

	@field:SerializedName("SUPPLY")
	val sUPPLY: Double,

	@field:SerializedName("MEDIAN")
	val mEDIAN: Double,

	@field:SerializedName("TYPE")
	val tYPE: String,

	@field:SerializedName("IMAGEURL")
	val iMAGEURL: String,

	@field:SerializedName("VOLUMEDAY")
	val vOLUMEDAY: Double,

	@field:SerializedName("VOLUME24HOUR")
	val vOLUME24HOUR: Double,

	@field:SerializedName("MARKET")
	val mARKET: String,

	@field:SerializedName("PRICE")
	val pRICE: Double,

	@field:SerializedName("CHANGEPCTDAY")
	val cHANGEPCTDAY: Double,

	@field:SerializedName("TOTALTOPTIERVOLUME24H")
	val tOTALTOPTIERVOLUME24H: Double,

	@field:SerializedName("FROMSYMBOL")
	val fROMSYMBOL: String,

	@field:SerializedName("LASTVOLUMETO")
	val lASTVOLUMETO: Double,

	@field:SerializedName("CHANGEPCT24HOUR")
	val cHANGEPCT24HOUR: Double,

	@field:SerializedName("OPENDAY")
	val oPENDAY: Double,

	@field:SerializedName("TOTALTOPTIERVOLUME24HTO")
	val tOTALTOPTIERVOLUME24HTO: Double,

	@field:SerializedName("VOLUMEDAYTO")
	val vOLUMEDAYTO: Double,

	@field:SerializedName("OPENHOUR")
	val oPENHOUR: Double,

	@field:SerializedName("CHANGE24HOUR")
	val cHANGE24HOUR: Double,

	@field:SerializedName("CHANGEHOUR")
	val cHANGEHOUR: Double,

	@field:SerializedName("HIGH24HOUR")
	val hIGH24HOUR: Double,

	@field:SerializedName("VOLUME24HOURTO")
	val vOLUME24HOURTO: Double,

	@field:SerializedName("LOWDAY")
	val lOWDAY: Double,

	@field:SerializedName("HIGHHOUR")
	val hIGHHOUR: Double,

	@field:SerializedName("MKTCAPPENALTY")
	val mKTCAPPENALTY: Double
)

data class MetaData(

	@field:SerializedName("Count")
	val count: Int
)

data class CoinInfSponsored(

	@field:SerializedName("Internal")
	val internal: String,

	@field:SerializedName("Rating")
	val rating: Rating,

	@field:SerializedName("BlockTime")
	val blockTime: Int,

	@field:SerializedName("ImageUrl")
	val imageUrl: String,

	@field:SerializedName("MaxSupply")
	val maxSupply: Double,

	@field:SerializedName("DocumentType")
	val documentType: String,

	@field:SerializedName("Algorithm")
	val algorithm: String,

	@field:SerializedName("Url")
	val url: String,

	@field:SerializedName("Name")
	val name: String,

	@field:SerializedName("Type")
	val type: Int,

	@field:SerializedName("ProofType")
	val proofType: String,

	@field:SerializedName("NetHashesPerSecond")
	val netHashesPerSecond: Double,

	@field:SerializedName("AssetLaunchDate")
	val assetLaunchDate: String,

	@field:SerializedName("FullName")
	val fullName: String,

	@field:SerializedName("Id")
	val id: String,

	@field:SerializedName("BlockNumber")
	val blockNumber: Int,

	@field:SerializedName("BlockReward")
	val blockReward: Int
)


data class Rating(

	@field:SerializedName("Weiss")
	val weiss: Weiss
)
