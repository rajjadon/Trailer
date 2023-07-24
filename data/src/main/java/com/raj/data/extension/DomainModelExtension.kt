package com.raj.data.extension

import com.raj.datasource.model.TrendingApiData
import com.raj.domain.model.TrendingDomain

fun TrendingApiData.toTrendingDomain() = TrendingDomain(
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
    posterPath = poster_path,
    releaseDate = release_date,
    title = title,
    video = video,
    voteAverage = vote_average,
    voteCount = vote_count
)