package cn.njxz.fitness.constants;


/**
 * Created by kalend.zhang on 2020/2/27.
 *
 * @author kalend.zhang
 * @date 2020/2/27 下午2:41
 */
public interface Constants {
    interface Base {
        /**
         * 开发环境
         */
        String DEV_CODE = "dev";
        /**
         * 调试环境
         */
        String TEST_CODE = "test";
        /**
         * 生产环境
         */
        String PROD_CODE = "prod";
        /**
         * 测试环境
         */
        String QA_CODE = "qa";
    }

    interface Price {
        /**
         * 时间对象时区
         */
        String LOCAL_DATE_TIME_OFFSET = "+8";

        /**
         * 价格失效默认时间
         */
        String PRICE_DEFAULT_END_TIME = "2999-12-31 23:59:59";

        /**
         * 默认销售单位: 件
         */
        String DEFAULT_UNIT_PIECE = "件";
    }

    interface Channel {
        /**
         * type :线上
         */
        String ONLINE = "ONLINE";
        /**
         * type:线下
         */
        String OFFLINE = "OFFLINE";
        /**
         * 新增/更新数据库操作成功返回
         */
        Integer OPERATE_DATASOURCE_SUCCESS = 1;
        /**
         * approvalStatus：上架
         */
        String APPROVAL_STATUS = "APPROVED";
        /**
         * approvalStatus：下架
         */
        String APPROVAL_STATUS_NOT = "UNAPPROVED";
    }

    interface Tag {
        String EFFECTIVE_DATE = "2000-01-01 00:00:01";
        String EXPIRE_DATE = "2099-12-31 23:59:59";
    }

    interface Sku {
        String CONVERT_SKU = "convertSku";
        String CONVERT_SUB_SKU = "convertSubSku";
    }

    interface Product {
        String APPROVED = "APPROVED";
        String UNAPPROVED = "UNAPPROVED";
        /**
         * ACCL 微购 3E
         */
        String MICRO_BUY_3E_AC_CL = "5";

        /**
         * ACEC产品 海外购非微购产品
         */
        String OUT_AC_EC = "6";

        /**
         * ACEC 海外购微购
         */
        String MICRO_BUY_OUT_AC_EC = "7";

        /**
         * ACEC 微购产品
         */
        String MICRO_BUY_AC_EC = "8";


    }

    int TRUE = 1;

    int FALSE = 0;


    /**
     * http返回码 成功
     */
    String HTTP_RESPONSE_CODE_SUCCESS = "0";

    /**
     * 是否删除标记 否
     */
    Integer IS_DELETED_FALSE = 0;

    /**
     * 是否删除标记 是
     */
    Integer IS_DELETED_TRUE = 1;

    /**
     * 操作成功标记
     */
    Integer OPERATE_SUCCESS = 1;

    /**
     * 操作失败标记
     */
    Integer OPERATE_FAILURE = 0;

    /**
     * 无效
     */
    String ACTIVE = "ACTIVE";

    /**
     * 有效
     */
    String INACTIVE = "INACTIVE";

    /**
     * code正则
     */
    String CODE_REGEX = "^[\\x01-\\x7f]*$";

    /**
     * 参数异常字段-code
     */
    String PARAM_VALIDATE_CODE = "code";

    /**
     * 参数异常信息-正则表达式
     */
    String PARAM_VALIDATE_MESSAGE = "正则表达式";

    /**
     * 参数异常信息-code不支持中文字符
     */
    String PARAM_VALIDATE_MESSAGE_CODE = "code不支持中文字符";

    /**
     * SKU CODE LIST最大元素个数
     */
    Integer MAX_SKU_CODE_LIST_SIZE = 20;

    /**
     * SKU CODE最大长度
     */
    Integer MAX_SKU_CODE_LENGTH = 50;

    /**
     * 数字 0
     */
    Integer MATH_ZERO = 0;

    /**
     * 数字1
     */
    Integer MATH_ONE = 1;

    /**
     * 字符串1
     */
    String STRING_ONE = "1";

    /**
     * 属性名-多规格产品排序
     */
    String VARIANT_ATTRIBUTE_SORT = "variant_attribute_sort";

    /**
     * 主图后缀
     */
    String MAIN_PICTURE_SUFFIX = "-1-1200Wx1200H_200Wx200H";

    /**
     * 查询收藏列表时：图片后缀
     */
    String COLLECTION_PICTURE_SUFFIX = "-1-1200Wx1200H_120Wx120H";

    /**
     * 品类
     */
    String CLASS_TYE = "class";

    /**
     * 标签
     */
    String TAG_TYPE = "tag";

    /**
     * 类目
     */
    String CATEGORY_TYPE = "category";

    interface Response {
        interface Message {
            String PREFIX = "error.commodity.message.";
        }
    }

    interface PageParam {
        String DESC = "desc";
    }

    /**
     * 搜索内部使用的字段名或索引别名等常量
     */
    interface EsSearch {

        /**
         * 排序使用
         */
        interface SortProperty {
            String NAME = "NAME";
            String PRICE = "PRICE";
            String GIFT_POINT = "GIFT_POINT";
            String PRODUCT_CODE = "PRODUCT_CODE";
        }

        interface PriceSectionType {
            String MONEY = "MONEY";
            String GIFT_POINT = "GIFT_POINT";
        }

        interface CategoryAggregateType {
            /**
             * ALL全部返回
             */
            String ALL = "ALL";
            /**
             * CHILDREN 返回当前类目的子类目
             */
            String CHILDREN = "CHILDREN";
            /**
             * BROTHER 返回当前类目的兄弟节点
             */
            String BROTHER = "BROTHER";
        }

        /**
         * ES自动提示需要的key命名，无实际意义，仅为获取suggest对象
         * ES支持同时提交多个suggest请求，故需要通过名称区分
         */
        String SUGGEST_NAME = "productNameCompletion";

        /**
         * ES聚合需要的key命名，无实际意义，仅为获取aggregate对象
         * ES支持同时提交多个aggregate请求，故需要通过名称区分
         */
        String PRICE_AGGREGATE = "pricesAggregate";

        String NESTED_PRICE_AGGREGATE = "nestedPricesAggregate";

        String CATEGORY_AGGREGATE = "categoryAggregate";

        String NESTED_CATEGORY_AGGREGATE = "nestedcategoryAggregate";
        /**
         * ES中指定为completion类型的字段名
         * 已使用独立索引，字段名为keyword
         */
        String SUGGEST_PROPERTY_NAME = "keyword";

        String DOT = ".";

        /**
         * 此对象包含渠道和角色相关的价格信息
         * 也是嵌套查询的path参数
         */
        String PRICE_LIST = "priceList";

        String DEFAULT_PRICE = "defaultPrice";

        /**
         * 此对象为类目的路径列表
         * 格式如 [[A,B,C],[A,D,E]]
         */
        String CATEGORY_PATH_LIST = "categoryPathList";

        String TAG_LIST = "tagList";

        /**
         * 以下为搜索需要的字段名
         */
        String SKU_CODE = "skuCode";

        String PRODUCT_CODE = "productCode";

        String PRODUCT_NAME="productName";

        String CHANNEL_CODE = "channelCode";

        String ROLE = "role";

        String INACTIVE = "inactive";

        String SEARCHABLE = "searchable";

        String DEFAULT_SKU = "defaultSku";

        String PRICE = "price";
        String GIFT_POINT = "giftPoint";

        String PRICE_SECTION = "priceSection";
        String GIFT_POINT_SECTION = "giftPointSection";

        String BASE_PRICE = "basePrice";

        String NAME = "name";
        String NAME_FOR_ORDER = "productNameForOrder";

        String SUMMARY = "summary";
        String KEYWORD_LIST = "keywordList";

        String CATEGORY = "categoryCode";
        String CLASS_CODE = "classCode";
        String TAG_CODE = "code";

        String KEY = "key";

        interface CategorySearch {

            String CODE = "code";

            String PARENT_CODE = "parentCode";

            String PARENT_ID = "parentId";

            String LAYER = "layer";

            String SORT = "sort";

            String STATUS = "status";
        }

    }

    interface ExtApi {

        String EXTAPIHEAD = "head";

        String EXTAPIFROM = "from";

    }

    interface Sync {

        Integer FULL_DATA = 1;

        Integer INCREMENT_DATA = 0;

    }
}
