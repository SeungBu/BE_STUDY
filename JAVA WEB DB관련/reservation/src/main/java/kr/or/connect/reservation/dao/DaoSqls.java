package kr.or.connect.reservation.dao;

public class DaoSqls {
    public static final String SELECT_PROMOTION_MA_IMG = "SELECT P.ID, P.PRODUCT_ID, F.SAVE_FILE_NAME "
            + "FROM PROMOTION P, FILE_INFO F, PRODUCT_IMAGE I "
            + "WHERE P.PRODUCT_ID = I.PRODUCT_ID "
            + "AND I.TYPE = \"ma\" "
            + "AND I.FILE_ID = F.ID;";
    public static final String SELECT_CATEGORY_STATICS = "SELECT COUNT(*) AS COUNT, CATEGORY_ID AS ID, Q.NAME AS NAME "
            + "FROM PRODUCT, CATEGORY Q "
            + "WHERE Q.ID = CATEGORY_ID "
            + "GROUP BY CATEGORY_ID";

    public static final String SELECT_ALL_PRODUCT_LIST = "SELECT I.DISPLAY_INFO_ID, ANY_VALUE(D.PLACE_NAME) AS PLACE_NAME, P.CONTENT AS PRODUCT_CONTENT, "
            + "P.DESCRIPTION AS PRODUCT_DESCRIPTION, D.PRODUCT_ID, P.CATEGORY_ID, "
            + "ANY_VALUE(Z.SAVE_FILE_NAME) AS PRODUCT_IMAGE_URL "
            + "FROM DISPLAY_INFO_IMAGE I, DISPLAY_INFO D, PRODUCT P, FILE_INFO Z, PRODUCT_IMAGE Q "
            + "WHERE I.DISPLAY_INFO_ID = D.PRODUCT_ID "
            + "AND D.PRODUCT_ID=P.ID "
            + "AND Q.TYPE=\"MA\" "
            + "AND Q.PRODUCT_ID = D.PRODUCT_ID "
            + "AND Q.FILE_ID = Z.ID "
            + "GROUP BY D.PRODUCT_ID "
            + "limit :start, :limit";

    public static final String SELECT_PRODUCT_LIST_BY_CATEGORY_ID = "SELECT I.DISPLAY_INFO_ID, ANY_VALUE(D.PLACE_NAME) AS PLACE_NAME, P.CONTENT AS PRODUCT_CONTENT, "
            + "P.DESCRIPTION AS PRODUCT_DESCRIPTION, D.PRODUCT_ID, P.CATEGORY_ID, "
            + "ANY_VALUE(Z.SAVE_FILE_NAME) AS PRODUCT_IMAGE_URL "
            + "FROM DISPLAY_INFO_IMAGE I, DISPLAY_INFO D, PRODUCT P, FILE_INFO Z, PRODUCT_IMAGE Q "
            + "WHERE I.DISPLAY_INFO_ID = D.PRODUCT_ID "
            + "AND D.PRODUCT_ID=P.ID "
            + "AND Q.TYPE=\"MA\" "
            + "AND Q.PRODUCT_ID = D.PRODUCT_ID "
            + "AND Q.FILE_ID = Z.ID "
            + "AND P.CATEGORY_ID = :CATEGORY_ID "
            + "GROUP BY D.PRODUCT_ID "
            + "limit :start, :limit";
}