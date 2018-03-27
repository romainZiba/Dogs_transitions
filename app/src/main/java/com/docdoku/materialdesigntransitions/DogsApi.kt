package com.docdoku.materialdesigntransitions

import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by romainz on 28/03/18.
 */
interface DogsApi {

    @GET("/api/breed/collie/images")
    fun getCollieImages(): Single<BreedResponse>
}