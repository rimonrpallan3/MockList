package com.example.mocklist.repository.api

import androidx.lifecycle.LiveData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Complete application API End-Point
 * Note some API have JSON Response, Some don't
 */

interface RestAPIEntity {

   /* @GET("reserve-usernames/username-exist")
    fun getUserNameExist(@Query("username") username: String): LiveData<ApiResponse<ApiResponseBody<UserNameStatusResponse>>>

    @POST("reserve-usernames/reserve-username")
    fun userNameReserve(@Query("username") UserNameReserve: String): LiveData<ApiResponse<ApiResponseBody<UserNameReserveResponse>>>

    @GET("users/phone-number-exist")
    fun getPhoneNumberExist(@Query("phoneNumber") phoneNumber: String): LiveData<ApiResponse<ApiResponseBody<UserNameStatusResponse>>>

    @POST("user-verification-otps/send-verification-code")
    fun sendVerificationOTP(
        @Query("reserveUsernameId") reserveUsernameId: Double,
        @Query("mobileNumber") phoneNumber: String
    ): LiveData<ApiResponse<ApiResponseBody<OTPSendResponse>>>

    @PATCH("user-verification-otps/verify-mobile")
    fun OTPVerfication(
        @Query("userVerificationId") userVerificationId: Double,
        @Query("otp") otp: String
    ): LiveData<ApiResponse<ApiResponseBody<OTPVerificationResponse>>>

    @POST("users")
    fun userRegistration(@Body body: UserRegistrationRequest): LiveData<ApiResponse<ApiResponseBody<UserRegistrationResponse>>>

    @GET("users/email-exist")
    fun emailVerification(@Query("email") email: String): LiveData<ApiResponse<ApiResponseBody<UserNameStatusResponse>>>

    @POST("users/send-auth-code")
    fun getAuthOTP(@Query("phoneNumber") phoneNumber: String): LiveData<ApiResponse<ApiResponseBody<AuthCodeOTPResponse>>>

    @POST("users/login")
    fun userLogin(@Body body: LoginRequest): LiveData<ApiResponse<LoginResponse>>

    *//**
     * PopularEvents
     *//*
    @GET("event-infos/get-popular-events")
    fun getPopularTrends(
        @Query("range") range: Int?,
        @Query("latitude") latitude: String?,
        @Query("longitude") longitude: String?,
        @Query(
            "limit"
        ) limit: Int,
        @Query("skip") skip: Int
    ): Call<PopularTrendsResponseModel>

    *//**
     * Most Recent Videos
     *//*
    @GET("video-details/get-recent-videos")
    fun getMostRecent(
        @Query("range") range: Int?,
        @Query("latitude") latitude: String?,
        @Query("longitude") longitude: String?,
        @Query(
            "limit"
        ) limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>?>

    *//**
     * Trending Videos
     *//*
    @GET("video-details/get-trending-videos")
    fun getTopTrending(
        @Query("range") range: Int?,
        @Query("latitude") latitude: String?,
        @Query("longitude") longitude: String?,
        @Query(
            "limit"
        ) limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>?>

    *//**
     * My Profile
     *//*
    @GET("users/my-profile")
    fun getMyProfile(): LiveData<ApiResponse<ApiResponseBody<MyProfileData>>>

    *//**
     * Other Profile
     *//*
    @GET("users/other-profile/{id}")
    fun getOtherProfile(@Path("id") id: Int): LiveData<ApiResponse<ApiResponseBody<MyProfileData>>>

    *//**
     * Categories fragment Listing in Explore
     *//*
    @GET("video-details/get-video-by-category")
    fun getCategoryList(
        @Query("category") category: String,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>>

    *//**
     * My Followers Video Listing Api
     *//*
    @GET("video-details/get-following-feed")
    fun getFollowersVideo(
        @Query("limit") limit: String,
        @Query("skip") skip: String
    ): Call<ApiResponseBody<VideoResponse?>>

    *//**
     * Concerts Listing Api
     *//*
    @GET("event-infos/get-all-events-by-category")
    fun getConcert(
        @Query("range") range: Int?,
        @Query("latitude") latitude: String?,
        @Query("longitude") longitude: String?
    ): LiveData<ApiResponse<ConcertResponseModel>>

    *//**
     * Event listing according to category
     *//*
    @GET("event-infos/get-events-by-category")
    fun getEventCategory(
        @Query("range") range: Int?,
        @Query("latitude") latitude: String?,
        @Query("longitude") longitude: String?,
        @Query(
            "category"
        ) category: String?,
        @Query("limit") limit: Int?,
        @Query("skip") skip: Int?
    ): Call<EventByCategoryResponseModel>


    *//**
     * Other Profile follow
     *//*
    @POST("users/follow/{id}")
    fun follow(@Path("id") id: Int): LiveData<ApiResponse<ApiResponseBody<FollowData>>>

    *//**
     * Other Profile unfollow
     *//*
    @DELETE("users/unfollow/{id}")
    fun unFollow(@Path("id") id: Int): LiveData<ApiResponse<ApiResponseBody<FollowData>>>

    *//**
     * To get video list  corresponding event id
     *//*

    @GET("event-infos/event-video-detail")
    fun getEventVideos(
        @Query("eventId") eventId: Int?,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>?>

    *//**
     *  Paginated page Explore Search for Suggested video
     *//*
    @GET("event-infos/get-user-video-event-by-search")
    fun getPaginatedExploreSearch(
        @Query("search") search: String,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
        @Query(
            "type"
        ) type: String
    ): Call<ApiResponseBody<VideoResponse?>?>

    *//**
     *    Explore Search  page for Suggested user and Concert
     *//*
    @GET("event-infos/get-user-video-event-by-search")
    fun getExploreSearch(
        @Query("search") search: String,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
        @Query(
            "type"
        ) type: String
    ): LiveData<ApiResponse<ExploreSearchResponseModel>>

    *//**
     *    Explore Search for Suggested user and concert
     *//*
    @GET("event-infos/get-user-video-event-by-search")
    fun getExploreSearchOld(
        @Query("search") search: String,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
        @Query(
            "type"
        ) type: String
    ): Call<ExploreSearchResponseModel>

    *//**
     *  to get category of for_you
     *//*
    @GET("video-details/for-you-top-trending-videos")
    fun getForYou(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>?>

    *//**
     * Logout
     *//*
    @POST("users/logout")
    fun logout(): LiveData<ApiResponse<Any>>

    *//**
     * set Upvotes and Downvotes Api
     *//*
    @POST("video-votes/vote")
    fun setVote(
        @Query("videoId") videoId: Int,
        @Query("type") type: String
    ): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * Api for change phone number
     *//*

    *//**
     * Email Validation
     *//*
    @POST("users/email-number-change-otp")
    fun getEmailOtp(@Query("email") email: String): LiveData<ApiResponse<EmailResponse>>

    *//**
     * Verify email change
     *//*
    @GET("users/verify-email-number-change")
    fun verifyChangePhoneEmail(
        @Query("otp") otp: String,
        @Query("otpId") otpId: Int
    ): LiveData<ApiResponse<ChangedPhoneNumberResponse>>

    *//**
     * set changed phone number
     *//*
    @POST("users/send-sms-otp")
    fun getPhoneNumber(@Query("phoneNumber") phoneNumber: String): LiveData<ApiResponse<EmailResponse>>

    *//**
     * Verify change phone number
     *//*

    @GET("users/verify-sms-otp")
    fun verifyChangedPhoneNumber(
        @Query("otp") otp: String,
        @Query("otpId") otpId: Int
    ): LiveData<ApiResponse<ChangedPhoneNumberResponse>>

    *//**
     *  get university lists
     *//*
    @GET("universities/get-list")
    fun getUniversityList(
        @Query("search") searchUniversity: String,
        @Query("skip") skip: Int,
        @Query("limit") limit: Int,
        @Query("type") type: String
    ): Call<UniversityModel>

    *//**
     *  get university lists
     *//*
    @GET("universities/get-list")
    fun getPopularUniversityList(
        @Query("search") searchUniversity: String,
        @Query("type") type: String
    ): LiveData<ApiResponse<PopularUniversityModel>>

    *//**
     *  get Registered University Otp
     *//*
    @POST("universities/register-through-university")
    fun getRegisterUniversityOtp(@Body body: UniversityRegisteredRequest): LiveData<ApiResponse<RegisteringUniversityOTP>>


    *//**
     * verify university email
     *//*
    @GET("universities/verify-university-email")
    fun verifyUniversityOtp(
        @Query("otp") otp: String,
        @Query("otpId") otpId: Int
    ): LiveData<ApiResponse<RegisteredOtpValidationResult>>

    *//**
     * verify  referral code
     *//*
    @POST("invite-codes/create-invite-mapping")
    fun verifyInviteCode(@Query("inviteCode") inviteCode: String): LiveData<ApiResponse<Any>>

    *//**
     * API for upload video to server
     *//*
    @Multipart
    @POST("video-details/upload")
    fun uploadVideo(
        @Part video: MultipartBody.Part,
        @Part thumbnail: MultipartBody.Part,
        @Part gif: MultipartBody.Part,
        @Part("detail") details: RequestBody
    ): Call<ApiResponseBody<VideoDetails>>


    *//**
     * Invite user
     *//*
    @POST("invite-codes/send-invite")
    fun inviteUser(@Query("email") email: String): LiveData<ApiResponse<Any>>

    *//**
     * get Invite Count
     *//*
    @GET("invite-codes/invite-details")
    fun getInviteUserCount(
        @Query("inviteCode") inviteCode: String,
        @Query("userId") userId: String
    ): LiveData<ApiResponse<InviteUserCount>>

    *//**
     * get Feedback Api
     *//*
    @POST("user-feedbacks/user-feedback")
    fun feedback(@Body body: FeedBackResponseModel): LiveData<ApiResponse<Any>>

    *//**
     * to get followers list in profile page
     *//*
    @GET("users/followers-list/{id}")
    fun getProfileFollowersList(
        @Path("id") id: Int?,
        @Query("filter") filter: String?
    ): Call<FollowerListResponseModel>


    *//**
     * to get following list in profile page
     *//*
    @GET("users/following-list/{id}")
    fun getProfileFollowingList(
        @Path("id") id: Int?,
        @Query("filter") filter: String?
    ): Call<FollowerListResponseModel>


    *//**
     * follow user
     *//*
    @POST("users/follow/{id}")
    fun followUser(@Path("id") userId: Int?): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * unfollow user
     *//*
    @DELETE("users/unfollow/{id}")
    fun unFollowUser(@Path("id") userId: Int?): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * to get upvote list in profile page
     *//*
    @GET("upvote-details/{userId}")
    fun getUpvotesDetailsList(
        @Path("userId") id: Int,
        @Query("filter") filter: String
    ): Call<UpvoteResponseModel>

    *//**
     * to get comment  list
     *//*
    @GET("comments/post")
    fun getComments(
        @Query("postId") postId: Int,
        @Query("filter") filter: String
    ): Call<CommentResponseModel>

    *//**
     * to post comment
     *//*
    @POST("comments")
    fun postComments(@Body body: PostCommentResponseBody): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * Edit profile
     *//*
    @PATCH("users/edit-profile")
    fun editProfile(@Body body: EditProfileRequestData): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * Edit profile
     *//*
    @PATCH("users/edit-profile")
    fun updateUserBioTxt(@Body body: UpdateUserBioTxt): LiveData<ApiResponse<ApiResponseBody<Any>>>



    *//**
     * Verify email address
     *//*
    @POST("users/verify-email")
    fun verifyEmailAddress(): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Change email address
     *//*
    @PATCH("users/edit-email")
    fun changeEmailAddress(@Query("email") email: String): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Upload binary file
     *//*

    @POST("users/upload-profile-image")
    fun uploadProfilePic(@Body body: RequestBody): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * get Feedback Api
     *//*
    @GET("users/blocked-list")
    fun getBlockedList(@Query("filter") filter: String): Call<BlockedUserModel>


    *//**
     * Block or unblock users
     *//*
    @GET("users/block-or-unblock/{id}")
    fun blockUnblock(@Path("id") id: Int?): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * get  myprofile feed
     *//*
    @GET("users/my-profile-feed")
    fun getMyProfileFeed(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): Call<ApiResponseBody<VideoResponse?>>


    *//**
     * get upVote Details
     * userId : user ID  of video uploaded person from Video Detail
     * VideoId : video Id of the particular video from Video detail
     * filter : paginated limit and skip values as json
     *
     *//*
    @GET("get /upvote-details/video")
    fun getUpVoteDetails(
        @Query("userId") userId: Int?,
        @Query("videoId") videoId: Int?,
        @Query("filter") body: String?
    ): Call<UpVoteModel>

    *//**
     * Is university Is verified or not Check
     *//*
    @GET("universities/is-verified")
    fun getIsUniversityVerified(): LiveData<ApiResponse<ApiResponseBody<UniversityIsVerified>>>
    *//**
     * Get University Info Details
     *
     *//*
    @GET("universities/university-info")
    fun getUniversityDetails(): LiveData<ApiResponse<ApiResponseBody<UniversityInfo>>>


    *//**
     * Message listing
     *//*
    @GET("message-group-views/list-message-groups")
    fun getMessageList(
        @Query("skip") skip: Int?,
        @Query("limit") limit: Int?
    ): Call<MessageListingResponseModel>


    *//**
     * get Chat call
     *//*

    @GET("message-groups/list-group-messages")
    fun getChat(
        @Query("groupId") groupId: Int?,
        @Query("skip") skip: Int?,
        @Query("limit") limit: Int?
    ): Call<ChatResponseModel>

    *//**
     * send message
     *//*
    @POST("messages/send-message")
    fun sendMessage(@Body body: SendMessageRequestModel): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Mute particular chat
     *//*
    @PATCH("message-groups/mute-group")
    fun muteChat(
        @Query("groupId") groupId: Int?,
        @Query("mute") mute: Boolean?
    ): LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * event interested is Going or interssted
     *//*
    @POST("event-user-mappings/create-event-status\n")
    fun getIsGoingOrInterested(@Body body: IsGoingInterestedRequestModel): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * report user account
     *//*
    @POST("report-users/report-user")
    fun reportUserAccount(@Body body: ReportUserAccountResponseModel) :LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * to check user have verfied univesity
     *//*
    @GET("universities/is-verified")
    fun isVerifiedUniversities(): LiveData<ApiResponse<ApiResponseBody<UniversityVerifyResponseModel>>>


    *//**
     * New users for chat
     *//*
    @GET("message-groups/chat-users")
    fun getNewUsersForChat(
        @Query("skip") skip: Int?,
        @Query("limit") limit: Int?,
        @Query("search") search: String?,
        @Query("sort") sort: String?
    ): Call<ChatNewUserModel>


    *//**
     * Create new message
     *//*
    @POST("message-groups/create-chat")
    fun createMessage(@Body body : CreateChatRequest) : LiveData<ApiResponse<ApiResponseBody<CreateChatResponseData>>>


    *//**
     * Change message read status
     *//*
    @POST("message-statuses/update-message-status")
    fun changeReadStatus(@Body body : ChangeMessageReadStatus) : LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Delete Message
     *//*
    @DELETE("message-groups/delete-chat-group")
    fun deleteMessage(@Query("groupId") groupId : Int?) : LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Clear Messages
     *//*
    @HTTP(method = "DELETE", path = "message-groups/clear-group-messages", hasBody = true)
    fun clearChat(@Body body : ClearMessage) : LiveData<ApiResponse<ApiResponseBody<Any>>>


    *//**
     * Upload binary file
     *//*
    @Multipart
    @POST("account-verifications/upload-proof")
    fun uploadVerificationImgList(@Part imgFiles: List<MultipartBody.Part>): LiveData<ApiResponse<ApiResponseBody<List<UploadIdProofResponse>>>>


    *//**
     * Edit profile
     *//*
    @POST("account-verifications/")
    fun uploadImageDetails(@Body body: UploadImageDetails): LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * block new video
     *//*
    @GET("users/new-video-block/{id}")
    fun blockNewVideo(@Path("id")id:Int?):LiveData<ApiResponse<ApiResponseBody<Any>>>

    *//**
     * delete user account
     *//*
    @PATCH("users/delete-account")
    fun deleteAccount():LiveData<ApiResponse<ApiResponseBody<Any>>>
*/}

