package com.raj.datasource.remote

import com.google.gson.Gson
import com.raj.datasource.remote.baseResponse.ErrorResponse
import com.raj.datasource.remote.error.HttpRequestError
import com.raj.datasource.remote.error.HttpRequestErrorCodes
import com.raj.datasource.remote.error.NetworkError
import org.json.JSONObject
import retrofit2.Response

fun SafeApiRequest.getErrorMessage(code: Int, message: String? = null): NetworkError {

    return when (code) {
        HttpRequestErrorCodes.TimeOut.code -> HttpRequestError.TimeOut().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ExpectationFailed.code -> HttpRequestError.ExpectationFailed().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CONTINUE.code -> HttpRequestError.Continue().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SWITCHING_PROTOCOLS.code -> HttpRequestError.SwitchingProtocols()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.PROCESSING.code -> HttpRequestError.Processing().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CREATED.code -> HttpRequestError.Created().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ACCEPTED.code -> HttpRequestError.Accepted().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NON_AUTHORITATIVE_INFORMATION.code -> HttpRequestError.NonAuthoritativeInformation()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.NO_CONTENT.code -> HttpRequestError.NoContent().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.RESET_CONTENT.code -> HttpRequestError.ResetContent().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PARTIAL_CONTENT.code -> HttpRequestError.PartialContent().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MULTI_STATUS.code -> HttpRequestError.MultiStatus().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.ALREADY_REPORTED.code -> HttpRequestError.AlreadyReported().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.IM_USED.code -> HttpRequestError.ImUsed().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MULTIPLE_CHOICES.code -> HttpRequestError.MultipleChoices().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MOVED_PERMANENTLY.code -> HttpRequestError.MovedPermanently().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FOUND.code -> HttpRequestError.Found().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SEE_OTHER.code -> HttpRequestError.SeeOther().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_MODIFIED.code -> HttpRequestError.NotModified().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.USE_PROXY.code -> HttpRequestError.UseProxy().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SWITCH_PROXY.code -> HttpRequestError.SwitchProxy().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.TEMPORARY_REDIRECT.code -> HttpRequestError.TemporaryRedirect()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.PERMANENT_REDIRECT.code -> HttpRequestError.PermanentRedirect()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.BAD_REQUEST.code -> HttpRequestError.BadRequest().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UNAUTHORIZED.code -> HttpRequestError.Unauthorized().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PAYMENT_REQUIRED.code -> HttpRequestError.PaymentRequired().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FORBIDDEN.code -> HttpRequestError.Forbidden().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_FOUND.code -> HttpRequestError.NotFound().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.METHOD_NOT_ALLOWED.code -> HttpRequestError.MethodNotAllowed().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_ACCEPTABLE.code -> HttpRequestError.NotAcceptable().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PROXY_AUTHENTICATION_REQUIRED.code -> HttpRequestError.ProxyAuthenticationRequired()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.REQUEST_TIMEOUT.code -> HttpRequestError.RequestTimeout().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.CONFLICT.code -> HttpRequestError.Conflict().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.GONE.code -> HttpRequestError.Gone().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.LENGTH_REQUIRED.code -> HttpRequestError.LengthRequired().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PRECONDITION_FAILED.code -> HttpRequestError.PreconditionFailed()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.PAYLOAD_TOO_LARGE.code -> HttpRequestError.PayloadTooLarge().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.URI_TOO_LONG.code -> HttpRequestError.UriTooLong().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UNSUPPORTED_MEDIA_TYPE.code -> HttpRequestError.UnsupportedMediaType()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.RANGE_NOT_SATISFIABLE.code -> HttpRequestError.RangeNotSatisfiable()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.EXPECTATION_FAILED.code -> HttpRequestError.ExpectationFailed()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.I_AM_A_TEAPOT.code -> HttpRequestError.IAmATeapot().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.MISDIRECTED_REQUEST.code -> HttpRequestError.MisdirectedRequest()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.UN_PROCESSABLE_ENTITY.code -> HttpRequestError.UnProcessableEntity()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.LOCKED.code -> HttpRequestError.Locked().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.FAILED_DEPENDENCY.code -> HttpRequestError.FailedDependency().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.UPGRADE_REQUIRED.code -> HttpRequestError.UpgradeRequired().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.PRECONDITION_REQUIRED.code -> HttpRequestError.PreconditionRequired()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.TOO_MANY_REQUESTS.code -> HttpRequestError.TooManyRequests().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.REQUEST_HEADER_FIELDS_TOO_LARGE.code -> HttpRequestError.RequestHeaderFieldsTooLarge()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.UNAVAILABLE_FOR_LEGAL_REASONS.code -> HttpRequestError.UnavailableForLegalReasons()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.INTERNAL_SERVER_ERROR.code -> HttpRequestError.InternalServerError()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.NOT_IMPLEMENTED.code -> HttpRequestError.NotImplemented().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.BAD_GATEWAY.code -> HttpRequestError.BadGateway().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.SERVICE_UNAVAILABLE.code -> HttpRequestError.ServiceUnavailable()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.GATEWAY_TIMEOUT.code -> HttpRequestError.GatewayTimeout().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.HTTP_VERSION_NOT_SUPPORTED.code -> HttpRequestError.HTTPVersionNotSupported()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.VARIANT_ALSO_NEGOTIATES.code -> HttpRequestError.VariantAlsoNegotiates()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.INSUFFICIENT_STORAGE.code -> HttpRequestError.InsufficientStorage()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.LOOP_DETECTED.code -> HttpRequestError.LoopDetected().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NOT_EXTENDED.code -> HttpRequestError.NotExtended().apply {
            message?.let {
                errorMessage = it
            }
        }

        HttpRequestErrorCodes.NETWORK_AUTHENTICATION_REQUIRED.code -> HttpRequestError.NetworkAuthenticationRequired()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        HttpRequestErrorCodes.SOMETHING_WENT_WRONG.code -> HttpRequestError.SomeThingWentWrong()
            .apply {
                message?.let {
                    errorMessage = it
                }
            }

        else -> HttpRequestError.SomeThingWentWrong().apply {
            message?.let {
                errorMessage = it
            }
        }
    }
}

fun <T : Any> SafeApiRequest.convertErrorBody(response: Response<T>?): NetworkError {
    val errorResponse = JSONObject(response?.errorBody()?.string() ?: "")
    val errorResponseString = errorResponse.toString()
    val error = Gson().fromJson(errorResponseString, ErrorResponse::class.java)
    error.code = response?.code()
    error.message = errorResponseString
    return getErrorMessage(error.code ?: 500, error.message)
}