package com.raj.data.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raj.datasource.model.RoomDbTrendingDomain
import com.raj.datasource.model.TrendingApiData
import com.raj.domain.model.TrendingDomain

fun TrendingApiData.toTrendingDomain(imageLoadingUrl: String) = TrendingDomain(
    adult = adult,
    backdropPath = backdrop_path,
    firstAirDate = first_air_date,
    genreIds = genre_ids,
    id = id,
    mediaType = media_type,
    name = name,
    originCountry = origin_country,
    originalLanguage = original_language,
    originalName = original_name,
    originalTitle = original_title,
    overview = overview,
    popularity = popularity,
    posterPath = "$imageLoadingUrl$poster_path",
    releaseDate = release_date,
    title = title,
    video = video,
    voteAverage = vote_average,
    voteCount = vote_count
)

fun RoomDbTrendingDomain.toTrendingDomain(imageLoadingUrl: String) = TrendingDomain(
    adult = adult,
    backdropPath = backdropPath,
    firstAirDate = firstAirDate,
    genreIds = Gson().fromJson(genreIds, object : TypeToken<List<String>>() {}.type),
    id = id,
    mediaType = mediaType,
    name = name,
    originCountry = Gson().fromJson(originCountry, object : TypeToken<List<String>>() {}.type),
    originalLanguage = originalLanguage,
    originalName = originalName,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = "$imageLoadingUrl$posterPath",
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun TrendingDomain.toRoomDbTrendingDomain(imageLoadingUrl: String) = RoomDbTrendingDomain(
    adult = adult ?: false,
    backdropPath = backdropPath ?: "",
    firstAirDate = firstAirDate ?: "",
    genreIds = Gson().toJson(genreIds),
    id = id ?: 0,
    mediaType = mediaType ?: "",
    name = name ?: "",
    originCountry = Gson().toJson(originCountry),
    originalLanguage = originalLanguage ?: "",
    originalName = originalName ?: "",
    originalTitle = originalTitle ?: "",
    overview = overview ?: "",
    popularity = popularity ?: 0.0,
    posterPath = "$imageLoadingUrl$posterPath",
    releaseDate = releaseDate ?: "",
    title = title ?: "",
    video = video ?: false,
    voteAverage = voteAverage ?: 0.0,
    voteCount = voteCount ?: 0
)