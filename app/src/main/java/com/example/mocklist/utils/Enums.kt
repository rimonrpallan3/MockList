package com.example.mocklist.utils


/**
 * For Network response
 */
enum class NetworkStatus {
    SUCCESS,
    ERROR,
    LOADING
}

/**
 * For Network response
 */
enum class PagedStatus {
    PAGE,
    ERROR,
    COMPLETED
}

/**
 * video listing
 */
enum class VideoListingEvents {
    COMMENT,
    PROFILE,
    VOTES,
    DETAILS
}

/**
 * video listing
 */
enum class VideoDetailsEvents {
    COMMENT,
    PROFILE,
    VOTES_UP,
    VOTES_DOWN,
    DIRECT_MSG,
    SHARE,
    REPORT
}


enum class FollowerType() {
    Following,
    Followers
}

/**
 * Video upload type
 */
enum class VideoUploadType {
    NORMAL,
    EVENT,
    UNIVERSITY
}

/**
 * Video filters
 */
enum class VideoFilterTypes(val label: String) {
    None("None"),
    Bilateral("Bilateral"),
    BoxBlur("BoxBlur"),

    /*Brightness("Brightness"),*/
    BulgeDistortion("Bulge Distortion"),

    /*Contrast("Contrast"),*/
    Crosshatch("Crosshatch"),

    /*CGAColorspace("CGAColorspace"),*/
    Exposure("Exposure"),

    /*FilterGroup("FilterGroup"),*/
    /*Gamma("Gamma"),*/
    GaussianBlur("GaussianBlur"),
    GrayScale("GrayScale"),
    Halftone("Halftone"),
    Haze("Haze"),
    HighlightShadow("HighlightShadow"),

    /*Hue("Hue"),*/
    Invert("Invert"),

    /*LookUpTable("LookUpTable"),*/
    Luminance("Luminance"),
    LuminanceThreshold("LuminanceThreshold"),
    Monochrome("Monochrome"),
    Opacity("Opacity"),

    /*Overlay("Overlay"),*/
    Pixelation("Pixelation"),
    Posterize("Posterize"),

    /* RGB("RGB"),*/
    Saturation("Saturation"),
    Sepia("Sepia"),

    /* Sharpen("Sharpen"),*/
    Solarize("Solarize"),
    SphereRefraction("SphereRefraction"),
    Swirl("Swirl"),

    /*ToneCurve("ToneCurve"),*/
    Tone("Tone"),
    Vibrance("Vibrance"),
    Vignette("Vignette"),
    WeakPixelInclusion("WeakPixelInclusion"),

    /*WhiteBalance("WhiteBalance"),*/
    ZoomBlur("ZoomBlur")
}

/**
 * Sorting type for listings
 */
enum class Sorting {
    ASC,
    DSC
}


/**
 * Message Bottom sheet actions
 */

enum class BottomMessageAction {
    CLEAR,
    BLOCK,
    REPORT,
    MUTE
}


enum class SettingsType() {
    NOTIFICATION,
    DIRECT_MESSAGING
}

enum class SettingDestinations {
    CHANGE_PHONE_NUMBER
}

enum class VoteType {
    upvote,
    downvote
}

enum class VoteTypeResponse {
    NULL,
    downvoted,
    upvoted
}

enum class PostVideoDetailsType {
    normal,
    university,
    event
}

enum class PostVideoDetailsSubType {
    following,
    recent,
    trending,
    category,
    forYou
}
enum class VideoListingType {
    Normal,
    Events
}