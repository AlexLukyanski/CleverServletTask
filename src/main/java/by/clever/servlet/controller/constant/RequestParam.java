package by.clever.servlet.controller.constant;

public final class RequestParam {

    private RequestParam() {

    }

    //FrontController parameter
    public final static String FRONT_CONTROLLER_ATTRIBUTE = "check";

    //Parameters for CRUD operations with MusicBandEntity
    public final static String BAND_ID = "bandID";
    public final static String BAND_NAME = "bandName";
    public final static String BAND_GENRE = "bandGenre";
    public final static String BAND_CREATION_DATE = "bandCreationDate";
    public final static String BAND_PHONE = "bandPhone";
    public final static String BAND_EMAIL = "bandEmail";

    public final static String PAGE_SIZE = "pageSize";
    public final static String PAGE_NUMBER = "pageNumber";
}
